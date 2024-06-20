package com.sorting.practice;

import java.util.ArrayList;
import java.util.List;

/*
 * Time complexity for average case is O(n2)
 */
public class SelectionSortExample {

	public static void main(String[] args) {

		List<Integer> list = SortingUtilityHelper.numbersList();

		// Now sort the integers using selection sort
		// for selection sort we need to find smallest element index and replace the elements
		for(int i=0;i<list.size()-1;i++) {
			int min_index = i;
			for (int j=i+1;j<list.size();j++) {
				if(list.get(j) < list.get(min_index)) {
					min_index = j;
				}
			}
			// swap
			SortingUtilityHelper.swapIndexes(i, min_index, list);
		}
		
		// now print sorted list
		System.out.println("========Sorted list=========");
		list.forEach(System.out::println);
	}
}
