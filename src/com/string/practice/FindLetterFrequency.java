package com.string.practice;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Find each letter frequency i.e., no of times repeated in given string
 */
public class FindLetterFrequency {

    public static void main(String[] args) {

        // refer : com.java.collection.framework.practice.MapJava8Features.java for finding frequency of each character

        String str = "easiest";

        // now find frequency of each letter/character in the word
        // LinkedHashMap preserves the insertion order
        Map<Character, Integer> countCharacters = getCountCharacters(str);

        // now print the map i.e., each letter with its frequency in the given word
        // iterate over the map using entrySet
        for (Map.Entry<Character, Integer> entry : countCharacters.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        // Approach-2: Using java 8 map features - above logic can be updated with java 8 map default methods as shown below
        Map<Character, Integer> countMap = getCountCharUsingJava8(str);

        // print map using java 8 foreach
        System.out.println("=====Approach-2: Using java 8===============");
        countMap.forEach((key, value) -> System.out.println(key + " " + value));
    }

    /**
     * This method uses java 8 map default methods and features to get a map with character and its count
     * @param str
     * @return
     */
    private static Map<Character, Integer> getCountCharUsingJava8(String str) {
        Map<Character,Integer> frequencyMap = new LinkedHashMap<>();

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            // there is a new method putIfAbsent introduced in java8 in map interface
            // it adds key and corresponding value if key is not present or not associated with null
            // putIfAbsent is a default method
            if (null == frequencyMap.get(ch)) {
                frequencyMap.putIfAbsent(ch,1);
            } else {
                // if key is already present and not null, then update its value by computing using a function which is represented in
                // lambda expression
                frequencyMap.computeIfPresent(ch, (character, count) -> count+1);
            }
        }
        return frequencyMap;
    }

    /**
     * This method prepares map consisting character and its count
     *
     * @param str
     * @return
     */
    private static @NotNull Map<Character, Integer> getCountCharacters(String str) {
        Map<Character, Integer> countCharacters = new LinkedHashMap<>();

        for(int i = 0; i<=str.length()-1; i++) {
            Character letter = str.charAt(i);
            // if the map doesn't contain the letter, add the letter and update its count to 1
            if(!countCharacters.containsKey(letter)) {
                countCharacters.put(letter, 1);
            } else {
                // if the map already contains the letter, then updates its frequency by adding 1 to its frequency
                countCharacters.put(letter, countCharacters.get(letter)+1);
            }
        }
        return countCharacters;
    }
}
