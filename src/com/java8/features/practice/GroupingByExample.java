package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class GroupingByExample {

    public static void main(String[] args) {

        //problem-1:	Count strings whose length > 3
        List<String> names = Arrays.asList("Lalitha","Kavi","Ali","Ram","Priya");

        long count = names.stream()
                .filter(name -> name.length() > 3)
                .count();

        System.out.println("The count is "+count);

        // problem-2: Grouping with Collectors
        // Group the names corresponding to their length

        Map<Integer,List<String>> map = names.stream()
                .collect(Collectors.groupingBy(String::length));
        // print map
        for (Entry<Integer, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // This is another way of printing the map i.e., it will call the toString() method on map
        System.out.println(map);
    }
}
