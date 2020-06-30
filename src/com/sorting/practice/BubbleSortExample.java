package com.sorting.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Time complexity for average case is O(n2)
 */
public class BubbleSortExample {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(32);
		list.add(8);
		list.add(57);
		list.add(12);
		list.add(89); 
		
		int numOfSwaps = 0;
		// now sort the list using bubble sort
		for (int i=0;i<list.size();i++) {
			for (int j=0;j<list.size()-1;j++) {
				if (list.get(j)>list.get(j+1)) {
					// swap those two numbers
					swapIndexes(j, j+1, list);
					numOfSwaps++;
				}
			}
			// after 1 traversal if no of swaps are zero means list is already sorted. No need to traverse again
			if (numOfSwaps == 0) 
				break;
		}
		
		System.out.println(list.toString());
	}
	
	static void swapIndexes(int j, int k, List<Integer> list) {
		int temp = list.get(j);
		list.set(j, list.get(k));
		list.set(k, temp);
	}
}
