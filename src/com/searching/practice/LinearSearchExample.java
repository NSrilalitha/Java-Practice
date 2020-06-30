package com.searching.practice;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchExample {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(32);
		list.add(8);
		list.add(57);
		list.add(12);
		list.add(89);
		
		doLinearSearch(list, 12);
	}

	private static void doLinearSearch(List<Integer> list, int key) {
		boolean isKeyPresent = false;
		// here I have to search for key and print the index of key in given list
		// if key is not present in the list print not found
		for (int i=0;i<list.size()-1;i++) {
			if(list.get(i) == key) {
				System.out.println(key + " is present at index : "+ i);
				isKeyPresent = true;
				break;
			}
		}
		if (!isKeyPresent) {
			System.out.println("Not found");
		}
		
	}
}
