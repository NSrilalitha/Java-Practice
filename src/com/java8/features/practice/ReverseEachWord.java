package com.java8.features.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Reverse each word in a string using java 8 streams only.
 *     Input : hello world
 *     output : olleh dlrow
 */
public class ReverseEachWord {

    public static void main(String[] args) {

        String str = "hello world";

        // Approach-1: Using StringBuilder with streams api
        String revStr = Arrays.stream(str.split("\\s+"))
                              .map(word -> new StringBuilder(word).reverse().toString())
                              .collect(Collectors.joining(" "));
        System.out.println(revStr.trim());

        // Approach-2: Using streams API
        String rev = Arrays.stream(str.split("\\s+"))
                .map(word -> word.chars()
                             .mapToObj(ch -> (char)ch)
                              .collect(Collectors.collectingAndThen(
                                      Collectors.toList(),
                                      list -> {
                                                        Collections.reverse(list);
                                                        return list.stream().map(String::valueOf).collect(Collectors.joining());
                                                        }
                               ))
                ).collect(Collectors.joining(" "));
        System.out.println("Reversed word : "+rev);
    }
}
