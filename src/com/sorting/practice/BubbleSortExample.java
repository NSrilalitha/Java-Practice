package com.sorting.practice;

import java.util.List;

/**
 * Bubble sort takes minimum time (Order of n) when elements are already sorted. Hence it is best to check if the array is already sorted or not beforehand, to avoid O(N2) time complexity.
 * Time complexity for average case is O(n2)
 */
public class BubbleSortExample {

	public static void main(String[] args) {

		List<Integer> list = SortingUtilityHelper.numbersList();

		int numOfSwaps = 0;
		// now sort the list using bubble sort
		int n = list.size();
		for (int i=0;i<n;i++) {
			for (int j=0;j<n-1;j++) {
				if (list.get(j)>list.get(j+1)) {
					// swap those two numbers
					SortingUtilityHelper.swapIndexes(j, j+1, list);
					numOfSwaps++;
				}
			}
			// after 1 traversal if no of swaps are zero means list is already sorted. No need to traverse again
			if (numOfSwaps == 0) 
				break;
		}
		
		System.out.println(list);
	}



}
