package com.java8.features.practice;

import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * Find the element that occurs most frequently.
 */
public class FindFrequentElement {

    public static void main(String[] args) {

        List<String> input = List.of("apple","banana","orange","banana","apple");

        String mostFrequentlement = input.stream()
                .collect(Collectors.groupingBy(word -> word, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Most frequently occured element : "+mostFrequentlement);

    }
}
