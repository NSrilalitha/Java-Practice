package com.java.collection.framework.practice;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListExample {

	public static void main(String[] args) {
		
		// LinkedList implements List, Queue interfaces.
		// LinkedList preserves insertion order. Allow duplicates
		List<String> names = new LinkedList<>();
		
		names.add("lal");
		names.add(0, "nitt");
		names.add("test");
		names.add("nitt");
		names.add("dup");
	
		// print list elements by iterating using foreach loop
		names.forEach((name) -> System.out.println(name));
		
		LinkedList<String> list = new LinkedList<>(names);
		
		list.addFirst("nittala");
		list.addLast("trial");
		System.out.println("============================");
		list.forEach((s) -> System.out.println(s));
		
		System.out.println("printing elements using descending iterator");
		// print elements in reverse direction using descendingIterator
		Iterator<String> itr = list.descendingIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("printing elements in forward direction using ListIterator");
		ListIterator<String> litr = list.listIterator();
		while(litr.hasNext()) {
			System.out.println(litr.next());
		}
		
		System.out.println("printing elements in backward direction using ListIterator");
		while(litr.hasPrevious()) {
			
			System.out.println(litr.previous());
		}
		
		System.out.println("===============printing list=============");
		System.out.println(list);
		
		System.out.println("========removing last occurance of any object========");
		list.removeLastOccurrence("nitt");	
		System.out.println(list);
		
		// sort linkedlist
		System.out.println("==========sorting linked list==============");
		Collections.sort(list);
		System.out.println(list);
	}
}
