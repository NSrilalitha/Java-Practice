package com.java.collection.framework.practice;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		
		
		// TreeSet sorts the collection in natural sorting order
		// The class should implement Comparable interface inorder to be sorted by TreeSet or else
		// we have to pass custom Comparator instance as argument of TreeSet constructor
		
		// Here String is predefined class in java and it implements Comparable interface. So TreeSet sorts this collection
		// of strings in natural sorting order
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("Sri");
		treeSet.add("Lalitha");
		treeSet.add("Ram");
		treeSet.add("Radha");
		
		// now print the treeSet.. it doesn't allow duplicates. and it sorts the collection in sorting order
		System.out.println("============TreeSet===========");
		// using method reference while printing element
		treeSet.forEach(System.out::println);
		
		// Now lets create collection of Student objects. 
		// verify what happens if Student class doesn't implement Comparable interface
		Set<Student> students = new TreeSet<>((s1,s2) -> s1.getName().compareTo(s2.getName()));
		Student student1 = new Student();
		student1.setId(101);
		student1.setName("Sri");
		
		Student student2 = new Student();
		student2.setId(102);
		student2.setName("Lalitha");
		
		students.add(student1);
		students.add(student2);
		
		// now print sorted students collection
		System.out.println("==========Sorted students collection==========");
		// it throws ClassCastException if Student class either not implementing Comparable interface or we are not passing comparator instance
		// to TreeSet Constructor
		students.forEach((student) -> System.out.println(student.getId() + " - " + student.getName()));

	}

}
