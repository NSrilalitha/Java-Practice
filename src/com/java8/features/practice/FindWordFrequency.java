package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find frequency of each word using Streams API
 */
public class FindWordFrequency {

    public static void main(String[] args) {

        List<String> sentences = List.of("Java is fun","Streams are powerful","Java is powerful");

        Map<String,Long> freqMap = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.toLowerCase().split("\\s+")))
                .collect(Collectors.groupingBy(word -> word,Collectors.counting()));

        System.out.println(freqMap);
    }
}
