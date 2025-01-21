package com.string.practice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Find each letter frequency i.e., no of times repeated in given string
 */
public class FindLetterFrequency {

    public static void main(String[] args) {

        String str = "easiest";

        // now find frequency of each letter/character in the word
        // LinkedHashMap preserves the insertion order
        Map<Character, Integer> countCharacters = new LinkedHashMap<>();

        for(int i=0;i<str.length()-1;i++) {
            Character letter = str.charAt(i);
            // if the map doesn't contain the letter, add the letter and update its count to 1
            if(!countCharacters.containsKey(letter)) {
                countCharacters.put(letter, 1);
            } else {
                // if the map already contains the letter, then updates its frequency by adding 1 to its frequency
                countCharacters.put(letter, countCharacters.get(letter)+1);
            }
        }

        // now print the map i.e., each letter with its frequency in the given word
        // iterate over the map
        countCharacters.forEach((key, value) -> System.out.println(key + " = " + value));
    }
}
