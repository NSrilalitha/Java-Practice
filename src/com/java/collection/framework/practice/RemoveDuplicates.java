package com.java.collection.framework.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Create a list and remove duplicates from the list
 * 
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		
		System.out.println("************Approach-1***********");
		// We can use another arraylist to hold only unique elements
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(22);
		list.add(32);
		list.add(5);
		list.add(22);
		list.add(10);
		
		List<Integer> newList = new ArrayList<>();
		
		// iterate through first list and retrieve only unique elements 
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			Integer num = itr.next();
			if(!newList.contains(num)) {
				newList.add(num);
			}
		}
		System.out.println("list :"+list.toString());
		System.out.println("new list :"+newList.toString());
		
		System.out.println("************Approach-2***********");
		// using LinkedHashSet -> here Set removes duplicates and LinkedHashSet preserves order as well
		Set<Integer> set = new LinkedHashSet<>();
		set.addAll(list);
		
		System.out.println("linked hashset : "+set.toString());
		
		System.out.println("************Approach-3***********");
		// using java 8 streams distinct() method
		List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
		System.out.println("distinct list :"+distinctList.toString());
		
		// sort list using java 8 streams
		List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
		System.out.println("sorted list :"+sortedList.toString());
		
		// sort list which contains unique elements using java 8
		List<Integer> sortedUniqueList = list.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("sorted unique list: "+sortedUniqueList.toString());
		
		
	}
}
