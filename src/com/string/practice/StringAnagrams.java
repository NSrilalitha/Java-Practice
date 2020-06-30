package com.string.practice;

import java.util.Arrays;

public class StringAnagrams {

	public static void main(String[] args) {
		
		
		String str = "anagram";
		String str1 = "margana";
		
		char[] arr1 = str.toLowerCase().toCharArray();
		char[] arr2 = str1.toLowerCase().toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(Arrays.equals(arr1, arr2)) {
			System.out.println("Anagrams");
		} else {
			System.out.println("Not Anagrams");
		}
		
		
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

