package com.java8.features.practice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class demonstrates handling null value into Set
 */
public class NullsInSet {

    public static void main(String[] args) {
        // HashSet : HashSet allows one null value, since it is backed by HashMap, it allows one null key
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("banana");
        set.add(null);
        set.add("grapes");
        set.add("guava");

        set.forEach(System.out::println);

        System.out.println("=========TreeSet Natural sorting=================");
        // now try to add null in TreeSet, where it uses natural sorting through String compareTo method
        // TreeSet throws NullPointerException if we try to add null value to set when used natural sorting, since null compares with another string in compareTo method
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("banana");
        //treeSet.add(null);
        treeSet.add("grapes");
        treeSet.add("guava");

        treeSet.forEach(System.out::println);

        System.out.println("============TreeSet custom sorting with comparator handling null safely========");
        Set<String> treeSet1 = new TreeSet<>(Comparator.nullsFirst(String::compareToIgnoreCase));
        treeSet1.add("Apple");
        treeSet1.add("banana");
        treeSet1.add(null);
        treeSet1.add("grapes");
        treeSet1.add("guava");

        treeSet1.forEach(System.out::println);
    }

}
