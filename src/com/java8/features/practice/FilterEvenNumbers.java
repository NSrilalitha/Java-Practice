package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers {

    public static void main(String[] args) {

        // Problem-1: Filter even numbers from a list of integers.
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        // print the even numbers
        nums.stream().filter(num -> num%2 == 0).forEach(num -> System.out.print(" "+num)); // using lambda expression
        nums.stream().filter(num -> num%2 == 0).forEach(System.out::println); // using method reference
        // Collect the even numbers
        List<Integer> evenNums = nums.stream().filter(num -> num%2 == 0).collect(Collectors.toList());
        System.out.println("printing the even numbers list");
        evenNums.forEach(System.out::println);

    }
}
