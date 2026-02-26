package com.java8.features.practice;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given a sentence, extract and combine the first letter of each word using Java Streams only.
 * Input:"Java Stream API"
 * Output:JSA
 */
public class FormNewString {

    public static void main(String[] args) {

        String str = "Java Stream API";

        String newStr = Arrays.stream(str.split("\\s+"))
                .map(word -> word.charAt(0))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(newStr);

    }
}
