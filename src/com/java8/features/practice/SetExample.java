package com.java8.features.practice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {

        // Add person objects to HashSet and check duplicates added or not

        System.out.println("=================HashSet======================");
        // HashSet doesn't allow duplicates
        Set<Person> set = new HashSet<>();

        // create person objects
        Person p1 = new Person("Sri", 20);
        Person p2 = new Person("Priya", 21);
        Person p3 = new Person("Sri", 20);
        Person p4 = new Person("Sindu", 22);
        Person p5 = new Person("Sri", 30);
        Person p6 = new Person("Abhi", 25);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);
        set.add(p6);

        // print Set using forEach
        set.forEach(System.out::println);

        // TreeSet Example
        System.out.println("======================TreeSet=================");
        // TreeSet uses sorting logic through Comparable or Comparator
        System.out.println("Option-1: To sort the Person objects, Person class implements Comparable interface and provide custom logic for soting");
        Set<Person> treeSet = new TreeSet<>();

        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        treeSet.add(p5);
        treeSet.add(p6);

        // now print TreeSet which will print the Person objects in sorting order
        treeSet.forEach(System.out::println);

        System.out.println("Option-2: To sort the Person objects, pass Comparator to TreeSet constructor");
        // Comparator to sort the Person object by age and then name
        Comparator<Person> byAgeThenName = (person1,person2) -> {
            int cmp = Integer.compare(person1.getAge(),person2.getAge());
            if (cmp == 0) {
                return person1.getName().compareTo(person2.getName());
            }
            return cmp;
        };
        Set<Person> treeSet1 = new TreeSet<>(byAgeThenName);
        treeSet1.add(p1);
        treeSet1.add(p2);
        treeSet1.add(p3);
        treeSet1.add(p4);
        treeSet1.add(p5);
        treeSet1.add(p6);

        treeSet1.forEach(System.out::println);


    }
}
