package com.java8.features.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindTopThreeScores {

    public static void main(String[] args){

        List<Integer> scores = Arrays.asList(91,95,99,90,100,89,97,94);

        // find top 3 scores from the list

        scores.stream()     // convert list to stream pipeline
                .sorted(Collections.reverseOrder()) // sort the list in reverse order to get highest scores first
                .limit(3) // limit the output to specified size, returns a stream
                .forEach(System.out::println); // terminal operation to print, either we can collect the stream to list and print manually
    }
}
