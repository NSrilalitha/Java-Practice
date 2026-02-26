package com.java8.features.practice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Given natural numbers from 1 to 9 with one number missing, find the missing number.
 * Input:[1, 2, 3, 4, 6, 7, 8, 9]
 * Output:5
 */
public class FindMissingNumber {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 6, 7, 8, 9);

        // Approach-1: This is O(N2) solution, numbers.contains(num) is O(n), for each number we are making this call
        IntStream.rangeClosed(1,9)
                .filter(num -> !numbers.contains(num))
                .findFirst()
                .ifPresent(num -> System.out.println("Missing number is "+num));

        // Approach-2: Optimal solution
        int n = 9;
        // Using this formula: sum(1..n)=n(n+1)/2
        int expectedSum = n * (n+1)/2;
        int currentSum = numbers.stream()
                .reduce(0, Integer::sum);

        //(or) Using mapToInt i.e., converting Stream<Integer> to IntStream
        /*
        int sum = numbers.stream() // Stream<Integer>
                .mapToInt(Integer::intValue) // convert to IntStream
                .sum();
        */
        int missingNum = expectedSum-currentSum;
        System.out.println("Missing number : " + missingNum);

        // Approach-3: Using Set, O(N) time complexity, O(N) space complexity
        Set<Integer> set = new HashSet<>(numbers);

        IntStream.rangeClosed(1,9)
                .filter(num -> !set.contains(num))
                .findFirst()
                .ifPresent(num -> System.out.println("Missing number : "+num));

        // Approach-4: Simple solution

        int missingN = IntStream.rangeClosed(1,9).sum() - numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Missing no is "+missingN);

    }
}
