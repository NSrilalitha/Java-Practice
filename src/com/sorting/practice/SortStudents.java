package com.sorting.practice;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SortStudents {

    public static void main(String[] args) {

        Student s1 = new Student("Lalitha", 1);
        Student s2 = new Student("Priya",2);
        Student s3 = new Student("geetha",5);
        Student s4 = new Student("Lalitha", 6);
        Student s5 = new Student("Lalitha",6);

        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);

        System.out.println(set);

        // sort the collection
        set.stream()
                .sorted((student1,student2) -> student1.getRoll_no()-student2.getRoll_no())
                .forEach(System.out::println);

        System.out.println("==========printing list ===========");

        List<Student> list = set.stream()
                .sorted((student1,student2) -> student1.getName().toLowerCase().compareTo(student2.getName().toLowerCase()))
                .collect(Collectors.toList());

        list.forEach(System.out::println);

        System.out.println("========= printing list in reverse order ===========");
        list.stream()
                .sorted((student1,student2) -> student2.getName().toLowerCase().compareTo(student1.getName().toLowerCase()))
                .forEach(System.out::println);

    }
}
