package com.java8.features.practice;

import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicateNumbers {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5,5,5,6,7,7,8,8);

        // find duplicate numbers from the list

        // before java - 8
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (Integer num : numbers) {
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, count + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        System.out.println("duplicate elements are :"+duplicates);

        // from java - 8
        List<Integer> duplicateNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("duplicate elements are : "+duplicateNumbers);


        // Find frequency of each word in given list
        List<String> words = Arrays.asList("cat","bat","rat","cat","rat","cat","mat","bat");

        words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .forEach((key, value) -> System.out.println(key + " " + value));
    }
}
