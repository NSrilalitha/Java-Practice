package com.java8.features.practice;

import java.util.Collections;
import java.util.stream.Collectors;

public class ReverseStringUsingStreams {

    public static void main(String[] args) {

        // string to be reversed
        String str = "hello";

        String rev = str.chars()  // Convert to IntStream (stream of ASCII values)
                .mapToObj(c -> (char)c)  // Convert the IntStream to Stream<Character>
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            StringBuilder sb1 = new StringBuilder();
                            list.forEach(sb1::append);  // Append characters to StringBuilder
                            return sb1.reverse().toString();  // Reverse and return the string
                        }
                ));
        System.out.println("reversed string using java 8 streams is "+rev);

        // Using java 8 streams with some alterations
        String reversedStr = str.chars()  // Convert to IntStream (stream of ASCII values)
                .mapToObj(c -> (char) c)  // Convert the IntStream to Stream<Character>
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),  // Collect characters into a list
                        list -> {
                            Collections.reverse(list);  // Reverse the list
                            return list.stream()
                                    .map(String::valueOf)  // Convert characters back to strings
                                    .collect(Collectors.joining());  // Join the characters back into a string
                        }
                ));
        System.out.println("reversed string using java 8 streams "+ reversedStr);
    }
}
