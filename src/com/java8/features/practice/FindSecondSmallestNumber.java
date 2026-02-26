package com.java8.features.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Find the 2nd smallest element in an array using Java streams:
 *
 * {4, 2, 7, 1, 5, 3, 6}
 *
 */
public class FindSecondSmallestNumber {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4, 2, 7, 1, 5, 3, 6);
        //numbers.stream().sorted(Comparator.naturalOrder()).skip(1).limit(1).forEach(System.out::println);

        numbers.stream().sorted().skip(1).findFirst().ifPresent(System.out::println);
    }
}
