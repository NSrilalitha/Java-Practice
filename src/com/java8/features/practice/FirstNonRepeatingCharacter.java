package com.java8.features.practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * find the fort non repeating characters in a give string
 * provided the two cases
 * String str="programming "
 * String str2="aabbccdd"
 *
 * slove it using without java 8 ?
 *
 * handle null pointer as well
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Input : ");
        String str = sc.nextLine();

        // edge case: when input string is null
        if (str == null || str.isEmpty()) {
            System.out.println("Input is null/empty");
            return;
        }
        //LinkedHashMap maintains the order of elements
        // store character frequency in LinkedHashMap
        str.chars()
                .mapToObj(ch -> (char)ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().intValue()==1)
                .findFirst()
                .ifPresentOrElse(
                        entry -> System.out.println("First non-repeating character is "+entry.getKey()),
        () -> System.out.println("No non-repeating character present in the given input string")
                );


    }
}
