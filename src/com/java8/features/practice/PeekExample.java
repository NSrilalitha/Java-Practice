package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PeekExample {

    public static void main(String[] args) {

        // Interview question : What is the output of below problem ?
        List<String> list = Arrays.asList("a", "b", "c");

        List<String> upper = list.stream()
                .peek(System.out::print) // prints during intermediate stage
                .map(String::toUpperCase)
                .collect(Collectors.toList()); // triggers the execution of the entire stream pipeline.

        // Answer: abc gets printed

        // NOTE : Streams are lazy – Intermediate operations like .peek() and .map() are not executed until a terminal operation (like .collect()) is called.

        System.out.println(upper);
    }
}
