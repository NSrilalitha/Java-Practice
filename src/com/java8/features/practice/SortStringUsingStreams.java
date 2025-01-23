package com.java8.features.practice;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * This class is to practice Streams api
 */
public class SortStringUsingStreams {

    public static void main(String[] args) {

        // string to be sorted in descending order
        String str = "bcade";

        // sorting a string in descending order using java 8 streams
        String desSortString = str.chars() // converts to int stream
                .mapToObj(c -> (char) c) // converting int stream to character stream
                .sorted() // sort the stream of characters
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            Collections.reverse(list); // reversing the list
                            return list.stream()
                                    .map(String::valueOf) // converting character to string
                                    .collect(Collectors.joining());

                        }
                ));
        System.out.println("The string sorted in reverse order is "+desSortString);
    }
}
