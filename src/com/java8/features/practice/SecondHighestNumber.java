package com.java8.features.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given the array:int a[] = {2,3,4,5,6,1,2,3,6,7,8,9,8};
 * Write a Java program to:
 * • Find the second-highest number
 * • Solve it using: Traditional Java approach (without Java 8) ,Java 8 Stream API
 */
public class SecondHighestNumber {

    public static void main(String[] args) {

        //Approach-1: Using java 8 streams API

        // case-1: input is primitive integer array
        int[] arr = new int[]{-9,-7,-1,-4,3,-2};
        Arrays.stream(arr)
                .boxed()// wraps primitive to Integer wrapper class
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(num -> System.out.println("Second highest number is "+num));

        // case-2: input is list of Integers
        List<Integer> list = List.of(7,7,7,7,7,7,7,7);
        list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(num -> System.out.println("Second highest number is "+num));

        // Approach-2: without using streams
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else {
                if (num > secondHighest) secondHighest = num;
            }
        }
        System.out.println("Second highest : "+secondHighest);


    }

}
