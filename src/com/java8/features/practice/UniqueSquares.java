package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UniqueSquares {

    public static void main(String[] args) {

        // Problem : Get Unique Squares of Even Numbers
        List<Integer> nums = Arrays.asList(1,2,3,4,4,5,6,6,7,8);

        // find unique squares of even numbers

        // Note: If the list is very large and contains many duplicates, it can be slightly more efficient to filter even numbers first, then remove duplicates, and then square
        List<Integer> evenSquares = nums.stream()
                .filter(num -> num%2 == 0) // find even numbers first
                .distinct() // get only unique even numbers
                .map(num -> num*num)
                .collect(Collectors.toList()); // collect the squares of even numbers

        // print the list
        evenSquares.forEach(System.out::println);
    }
}
