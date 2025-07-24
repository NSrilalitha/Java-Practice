package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringsByFirstLetter {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("Apple","banana","avacado","blue berry","orange");

        Map<Character, List<String>> map = words.stream()
                .collect(Collectors.groupingBy(word -> word.toLowerCase().charAt(0)));
        // printing map directly
        System.out.println(map);

        // iterate through map and print values manually
        for(Map.Entry<Character, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
