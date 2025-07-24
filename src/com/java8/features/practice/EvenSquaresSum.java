package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;

public class EvenSquaresSum {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 4);

        // find even numbers, then find unique numbers, then calculate squares, then determine their sum and return it
        int sum = numbers.stream()
                .peek(n -> System.out.println("Original: " + n))
                .filter(n -> n % 2 == 0)
                .peek(n -> System.out.println("even after filter is " + n))
                .distinct()
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println("sum of unique even squares is "+sum);
    }
}
