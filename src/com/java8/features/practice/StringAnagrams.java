package com.java8.features.practice;

import java.util.*;
import java.util.stream.Collectors;

/**
 * String arr[] = { "abcd ",  "java",  "dcba",  "ajav",  "xyz",  "epam",  "pame",  "aepm" };
 *
 * O/p:
 *
 * [epam, pame, aepm] contains same character
 *
 * [java, ajav] contains same character
 *
 * [abcd, dcba] contains same character
 */
public class StringAnagrams {

    public static void main(String[] args) {

        String arr[] = { "abcd ",  "java",  "dcba",  "ajav",  "xyz",  "epam",  "pame",  "aepm" };

        Map<String, List<String>> feq = Arrays.stream(arr)
                .map(String::trim) // remove trailing spaces
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);  //key = sorted characters
                }));

        System.out.println(feq);

        feq.values().stream()
                .filter(list -> list.size()>1) // only groups with same characters
                .forEach(System.out::println);

        // Above approach can be completely done using Streams API as below

        List<List<String>> result = Arrays.stream(arr)
                .map(String::trim)
                .collect(Collectors.groupingBy(word ->
                    word.chars()
                            .mapToObj(ch -> (char)ch)
                            .sorted()
                            .map(String::valueOf)
                            .collect(Collectors.joining())
                ))
                .values().stream()
                .filter(list -> list.size()>1)
                .collect(Collectors.toList());

        System.out.println(result);

    }
}
