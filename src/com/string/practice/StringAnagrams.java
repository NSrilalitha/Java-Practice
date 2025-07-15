package com.string.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringAnagrams {

	public static void main(String[] args) {

		String str1 = "anagram";
		String str2 = "margana";

		// Approach-1: Using arrays sort function
		System.out.println("anagram and margana are anagrams: " + isAnagramUsingArrays(str1, str2));

		// Approach-2: Using Hashmap
		System.out.println("anagram and margana are anagrams: " + isAnagramUsingHashMap(str1, str2));

		// Approach-3: Using Frequency count array
		System.out.println("anagram and margana are anagrams: " + isAnagramUsingFrequencyCountArray(str1, str2));
	}

	// Approach using frequency count array
	/*
	Time complexity: The algorithm runs in O(n) time, making it an optimal solution for large strings.
Space complexity: The space complexity is O(1), since the size of the frequency array is fixed (256 for ASCII), which is constant and does not depend on the size of the input strings.
	 */
	private static boolean isAnagramUsingFrequencyCountArray(String word, String anagram) {
		// If lengths don't match, they can't be anagrams
		if (word.length() != anagram.length()) {
			return false;
		}

		// Create a frequency count array (assuming ASCII characters, size 256)
		int[] frequencyCount = new int[256];  // ASCII characters range from 0 to 255

		// Increment the count for characters in word
		for (int i = 0; i < word.length(); i++) {
			frequencyCount[word.charAt(i)]++;
		}

		// Decrement the count for characters in anagram
		for (int i = 0; i < anagram.length(); i++) {
			frequencyCount[anagram.charAt(i)]--;
			if (frequencyCount[anagram.charAt(i)] < 0) {
				return false; // If any character has negative count, not an anagram
			}
		}

		// the above logic can optimized as shown below
		/*
		// Step 1: Count frequencies for both strings
    	for (int i = 0; i < word.length(); i++) {
        	frequencyCount[word.charAt(i)]++;  // Increment count for characters in str1
        	frequencyCount[anagram.charAt(i)]--;  // Decrement count for characters in str2
    	}

    	// Step 2: Check if the frequencies are balanced (all should be zero)
    	for (int i = 0; i < 256; i++) {
        	if (frequencyCount[i] != 0) {
            	return false;  // If any count is not zero, they are not anagrams
        	}
    	}
		 */
		// If all counts are zero, the strings are anagrams
		return true;
	}

	/*
	This method finds out given two strings anagram or not using Arrays sort function
	Time Complexity: O(n log n) (dominated by the sort operation)
    Space Complexity: O(n) (due to the space used by the sorting algorithm)
	 */
	private static boolean isAnagramUsingArrays(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false; // If lengths differ, they can't be anagrams
		}
		// Convert strings to character arrays
		char[] arr1 = str1.toLowerCase().toCharArray();
		char[] arr2 = str2.toLowerCase().toCharArray();
		// Sort both character arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		// Compare the sorted arrays
		return Arrays.equals(arr1, arr2);
	}

	// Optimized approach using HashMap
	/*
	Time complexity : O(N), Space complexity: O(1)
	 */
	private static boolean isAnagramUsingHashMap(String word, String anagram) {
		// If lengths don't match, they can't be anagrams
		if (word.length() != anagram.length()) {
			return false;
		}

		// Create a HashMap to count the frequency of each character
		Map<Character, Integer> frequencyMap = new HashMap<>();

		// Increment frequency for each character in word
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

		// Decrement frequency for each character in anagram
		for (int i = 0; i < anagram.length(); i++) {
			char c = anagram.charAt(i);
			if (!frequencyMap.containsKey(c)) {
				return false; // Character in anagram doesn't exist in word
			}
			frequencyMap.put(c, frequencyMap.get(c) - 1);
			if (frequencyMap.get(c) < 0) {
				return false; // More occurrences in anagram than in word
			}
		}

		// If we reach here, frequencies must match
		return true;
	}

}

enum Days {

	SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7);

	int dayCount;

	Days(int code) {
		this.dayCount = code;
	}

	int getDayCount() {
		return this.dayCount;
	}
}

