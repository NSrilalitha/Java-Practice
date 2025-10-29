package com.sorting.practice;

import java.util.List;

/*
 * Time complexity for insertion sort :
 *
 * best case : O(N)
 * average/worst case is O(n2)
 */
public class InsertionSortExample {

	public static void main(String[] args) {

		// sort the list of numbers in ascending order

		// Insertion sort best suitable for small lists
		List<Integer> list = SortingUtilityHelper.numbersList();

        // i starts from 1, treating first part as already sorted
		for(int i=0;i<list.size();i++) {

			int key = list.get(i); // element to be inserted into sorted part
			int j = i-1;

			while (j>=0 && list.get(j) > key) { // for descending order just change > to < i.e., list.get(j) < key
				// shift current element one position right side, create hole to insert key into its correct position
				list.set(j+1, list.get(j));
				j--;
			}
			// Insert the key into its correct position
			list.set(j+1, key);
		}
		
		// now print list
		System.out.println("=========Sorted list=====");
		list.forEach((num) -> System.out.print(num + " "));
	}
}
