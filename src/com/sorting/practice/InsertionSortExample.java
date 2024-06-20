package com.sorting.practice;

import java.util.ArrayList;
import java.util.List;

/*
 * Time complexity for average case is O(n2)
 */
public class InsertionSortExample {

	public static void main(String[] args) {
		
		// Insertion sort best suitable for small lists
		List<Integer> list = SortingUtilityHelper.numbersList();

        // insertion sort swaps adjacent elements
		for (int i=1; i<list.size();i++) {
			for (int j=i;j>0;j--) {
				if (list.get(j) < list.get(j-1)) {
					//swap
					int temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, temp);
				}
				
			}
		}
		
		
		// now print list
		System.out.println("=========Sorted list=====");
		list.forEach((num) -> System.out.print(num + " "));
	}
}
