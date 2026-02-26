package com.java8.features.practice;

import java.util.stream.IntStream;

/**
 * Check if a given String is palindrome using Java 8 Streams , without reversing the string.
 */
public class PalindromeCheck {

    public static void main(String[] args) {

        String str = "madam";

        boolean isPalindrome = IntStream.range(0,str.length()/2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length()-i-1));

        if(isPalindrome) {
            System.out.println("Given string is palindrome");
        } else {
            System.out.println("Given string is not Palindrome");
        }

        // Case-Insensitive Version
        boolean isPal = IntStream.range(0,str.length()/2)
                .allMatch(i -> Character.toLowerCase(str.charAt(i)) ==
                        Character.toLowerCase(str.charAt(str.length()-i-1)));


    }
}
