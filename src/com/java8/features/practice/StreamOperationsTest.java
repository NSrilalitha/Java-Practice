package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOperationsTest {

    public static void main(String[] args) {

        // Get list of String which starts with letter s
        List<String> words = Arrays.asList("sample","cat","suit","version","java");

        List<String> filt = words.stream().filter(word -> word.toLowerCase().startsWith("s")).collect(Collectors.toList());

        filt.forEach(System.out::println);


        // From list of integers, get each integer with its count in the list
        List<Integer> list = Arrays.asList(1,3,5,1,7,3,3,7,2,9);

        Map<Integer,Long> freqMap = list.stream()
                .collect(Collectors.groupingBy(n -> n,Collectors.counting()));

        System.out.println(freqMap);




    }
}
