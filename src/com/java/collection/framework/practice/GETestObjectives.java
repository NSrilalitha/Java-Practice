package com.java.collection.framework.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class GETestObjectives {

	public static void main(String[] args) {
		
		
		List<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("7");
		list.add("3");
		list.add("10");
		
		System.out.println("*********ConcurrentModificationException demo***********");
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String value = itr.next();
			System.out.println(value);
			// while iterating if we try to change the structure of collection we get
			// ConcurrentModificationException
			//list.remove("7");
			// but if we use iterator remove eg. itr.remove("7") we dont get exception
			if (value == "7") {
				itr.remove();
			}
			//System.out.println("is it removed : " +list.remove("13"));
		}
		
		System.out.println(list);
		
		System.out.println("===========Conversion of int[] array to List<Integer>========");
		// convert int arr to list of Integer
		int[] arr = {1,2,5,8};
		
		List<Integer> list1 = new ArrayList<Integer>();
		/*
		for (int i=0;i<arr.length;i++) {
			list1.add(arr[i]);
		}
		System.out.println(list1); */
		
		// we can print arr using streams
		System.out.println("=========printing int arr using IntStream=======");
		IntStream.of(arr).forEach(System.out::println);
		// using java 8 IntStream to convert int[] to List<Integer>
		IntStream.of(arr).forEach(element -> list1.add(element));
		System.out.println(list1);
		
		
		// Below line gives compile time error saying "Type mismatch: cannot convert from List<int[]> to List<Integer>"
		// Because we can convert int to Integer but we can't convert int[] to List<Integer> type casting will not happen automatically
		//List<Integer> nums = Arrays.asList(arr);

	}

}
