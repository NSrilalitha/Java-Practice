package com.java8.features.practice;

/**
 * Write a program find Vowel Count in String using Java 8
 */
public class FindVowelCount {

    public static void main(String[] args) {

        String str = "hello world";

        // Approach-1:
        Long vowelCount = str.chars()
                .map(Character::toLowerCase)
                .filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                .count();

        System.out.println(vowelCount);

        // Approach-2:
        Long count = str.toLowerCase().chars()
                .filter(ch -> "aeiou".indexOf(ch) != -1)
                .count();
        System.out.println(count);
    }
}
