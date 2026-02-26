package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Reverse a list using Streams API
 */
public class ReverseList {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,4,5,7,9,11);

        // now reverse the list using Streams API
        List<Integer> reversed = IntStream.range(0,numbers.size())
                .mapToObj(i -> numbers.get(numbers.size()-i-1))
                .collect(Collectors.toList());

        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        System.out.println(reversed);
    }
}
