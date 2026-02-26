package com.java8.features.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Frequency of each element in a list of integers

{1, 1, 1, 2, 2, 2, 3, 3, 3, 2, 2, 2, 4, 4, 9, 4, 4, 5, 5, 5, 6, 7, 7, 7, 25, 66, 99, 99, 77},


 */
public class FindIntegerCount {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 2, 2, 3, 3, 3, 2, 2, 2, 4, 4, 9, 4, 4, 5, 5, 5, 6, 7, 7, 7, 25, 66, 99, 99, 77));

        List<String> list = numbers.stream()
                .collect(Collectors.groupingBy(n -> n,Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new String(entry.getKey() + " is repeated " + entry.getValue().intValue() + " times"))
                .collect(Collectors.toList());

        list.forEach(System.out::println);

    }
}
