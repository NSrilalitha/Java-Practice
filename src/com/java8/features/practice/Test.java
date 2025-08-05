package com.java8.features.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

    String[] args = {"abc", "lalitha"};

    public static void main(String[] args) {

        System.out.println("length : " + args.length);

        Test ob = new Test();
        System.out.println("class level variable args length is "+ob.args.length);


        // What is the output of below program
        String s1 = "March";
        String s2 = "March";
        String s3 = s1;
        s1 = "April";
        s2.concat("May");
        String newS3 = s3.concat("June");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(newS3);


        // find duplicate numbers
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5,5,5,6,7,7,8,8);

        List<Integer> duplicates = numbers.stream()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        duplicates.forEach(System.out::println);

        // before java 8
        //step-1: find Map with key as number and value as its frequency
        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for(int num:numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
        }

        List<Integer> dup = new ArrayList<>();
        // step-2: iterate through map and find keys for which frequency is greater than 1
        for(Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue()>1) {
                dup.add(entry.getKey());
            }
        }
        System.out.println(dup);
    }
}
