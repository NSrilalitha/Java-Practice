package com.string.practice;

import java.util.*;

/**
 * Find the first non-repeating character in given string for eg: if input string is "analogy"
 * then program should return n
 */
public class FindNonRepeatingCharacter {

    public static void main(String[] args) {

        String str = "easiest";

        // Method-1: Using LinkedHashMap
        System.out.println("Method-1: Using LinkedHashMap");
        System.out.println("===============================");
        findNonReaptingCharUsingMap(str);

        // Method-2: Using indexOf and lastIndexOf built in functions
        System.out.println("Method-2: Using indexOf and lastIndexOf built in functions");
        System.out.println("============================================================");
        for(int i=0;i<=str.length()-1;i++) {
            char ch = str.charAt(i);
            if(str.indexOf(ch) == str.lastIndexOf(ch)) {
                System.out.println("The first non-repeating character in the given word is "+ch);
                break;
            }
        }

        // Method-3: Comparing each character with its next characters in the given word
        System.out.println("Method-3: Comparing each character with its next characters in the given word");
        System.out.println("==============================================================================");
        for(int i=0;i<str.length();i++) {
            int flag = 0;
            for(int j=0;j<str.length();j++) {
                if(i!=j && str.charAt(i) == str.charAt(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The first non-repeating character in the given word is "+str.charAt(i) +" and present at index "+i);
                break;
            }
        }

        // Method-4: Using an array for frequency count
        System.out.println("Method-4: Using an array for frequency count");
        System.out.println("=============================================");
        findNonRepeatingCharacter(str);

        // Method-5: Using java 8 Streams API
        System.out.println("Method-5: Using java 8 Streams API");
        System.out.println("===================================");
        char ch = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst()
                .orElse('\0');
        System.out.println("First unique character is "+ch);

    }

    /**
     * This method uses frequency array to find the first unique character.
     *
     * If the string contains only lowercase English letters, we can use an array of fixed size (26 characters) to count the frequency of each character. This method avoids the overhead of a HashMap.
     *
     * @param str
     */
    private static void findNonRepeatingCharacter(String str) {
        int[] freq = new int[256]; // assuming ASCII character set

        // step 1: building the frequency array
        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i)]++;
        }

        // step 2: Find the first character with frequency 1
        for(int i=0;i<str.length();i++) {
            if(freq[str.charAt(i)] == 1) {
                System.out.println("The first unique character is "+str.charAt(i));
                break;
            }
        }
    }

    /**
     * This method uses LinkedHashMap to find the first unique character
     * @param str
     */
    private static void findNonReaptingCharUsingMap(String str) {

        /* Converting String to String[] where each character of a string converted to String in the array */
        String[] letters = str.split("");

        /* since we want the first non repeating character, we have to preserve the insertion order. So using LinkedHashMap */
        // To find the count of each character in given word refer FindLetterFrequency program in this package
        Map<String, Integer> countCharacters = new LinkedHashMap<>();
        for(String letter: letters) {
            countCharacters.put(letter, Collections.frequency(Arrays.asList(letters), letter));
        }

        // now query the the first non-repeating character i.e., first letter with frequency 1

        // As LinkedHashMap maintains insertion order, first character with
        // count 1 should return first non repeated character
        for(Map.Entry<String, Integer> entry : countCharacters.entrySet()) {
            if(entry.getValue() == 1) {
                System.out.println("The first non-repeating character in the given word is "+entry.getKey());
                break;
            }
        }

    }
}
