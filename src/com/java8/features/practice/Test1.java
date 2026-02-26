package com.java8.features.practice;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {

        // Problem-1: Sorting list of strings
        List<String> words = new ArrayList<>(Arrays.asList("lalitha","sri","abc","priya","arun"));

        // ascending order
        words.stream().sorted().forEach(System.out::println);

        System.out.println("sorted in reverse order");
        words.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Problem-2: Sort strings by their length
        List<String> sortedByLength = words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        System.out.println("sorted by their length :"+sortedByLength);

        // Problem-3: findFirst example
        System.out.println("Finding first word using findFirst function");
        Optional<String> firstWord = words.stream().findFirst();
        firstWord.ifPresent(System.out::println);


        // Problem-4: summarizingInt example
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Count : "+stats.getCount());
        System.out.println("Sum : "+stats.getSum());
        System.out.println("Average : "+stats.getAverage());
        System.out.println("Max : "+stats.getMax());
        System.out.println("Min : "+stats.getMin());


        // Problem-3: Iterate through Map

        Map<String,Integer> map = new TreeMap<>();
        map.put("arun",1);
        map.put("kiran",2);
        map.put("abc",7);
        map.put("priya",4);
        map.forEach((key,value) -> System.out.println(key + " : " + value));
    }
}
