package com.searching.practice;

import com.sorting.practice.BubbleSortExample;
import com.sorting.practice.SortingUtilityHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Worst case is O(logn) and best case is O(1)
 * 
 * To perform binary search, the collection/array should be sorted first. And the collection
 * should be randomly accessible. i.e., we can use binary search for arrays and list/vector
 */
public class BinarySearchExample {

	public static void main(String[] args) {

		List<Integer> list = SortingUtilityHelper.numbersList();

        // sort the list using insertion sort
		sortListUsingInsertionSort(list);
		
		// print sorted list
		System.out.println("=========Sorted list==========");
		System.out.println(list);
		
		// now perform search operation using binary search
		doBinarySearch(list, 89);
	}

	private static void doBinarySearch(List<Integer> list, int key) {
		// search for key in given list
		// if found print the index of the key
		// if not found print not found message
		boolean isPresent = false;
		int start = 0;
		int end = list.size()-1;
		
		while (start <= end) {
			// find mid element
			int mid = (start + end)/2;
			
			if (key == list.get(mid)) {
				isPresent = true;
				System.out.println(key + " is present at index : "+mid);
				break;
			} else if(key < list.get(mid)) {
				end = mid-1;
			} else if (key > list.get(mid)) {
				start = mid+1;
			}
		}
		if (!isPresent) {
			System.out.println(key + " not found");
		}
		
	}

	private static void sortListUsingInsertionSort(List<Integer> list) {
		// insertion sort does sorting by swapping adjacent elements
		for (int i=1;i<list.size();i++) {
			for (int j=i;j>0;j--) {
				if (list.get(j) < list.get(j-1)) {
					// swap those adjacent elements
					int temp = list.get(j);
					list.set(j, list.get(j-1));
					list.set(j-1, temp);
				}
			}
		}
		
	}
}
