package com.sorting.practice;

import java.util.ArrayList;
import java.util.List;

import static com.sorting.practice.SortingUtilityHelper.numbersList;

/*
 * Time complexity for average case is O(nlogn) and for worst case is O(n2)\
 * It is an in-place sorting algorithm i.e., it doesn't need any extra space to sort
 * 
 * 
 * Quick sort is the fastest and efficient sorting algorithm.
 * 
 * 
 * Partition the list like elements present left to pivot are smaller and elements present
 * right to pivot are greater than pivot.
 * 
 * After partitioning sort the left side sublist and right side sublist separately
 * 
 * Reference: https://www.youtube.com/watch?v=COk73cpQbFQ
 */
public class QuickSortExample {

	public static void main(String[] args) {

        List<Integer> list = SortingUtilityHelper.numbersList();

        // Now sort the list using QuickSort
		doQuickSort(list, 0, list.size()-1);
		
		// print the list
		System.out.println("=============print sorted list=============");
		list.forEach(System.out::println);
	}

	private static void doQuickSort(List<Integer> list, int start, int end) {
		if (start < end) {
			// now partition the list 
			int pIndex = doPartititon(list, start, end);
			// now sort the left segment of list
			doQuickSort(list,start,pIndex-1);
			// now sort the right segment of list
			doQuickSort(list,pIndex+1,end);
		}	
	}

	private static int doPartititon(List<Integer> list, int start, int end) {
		// lets initially consider right most element as pivot
		Integer pivot = list.get(end);
		// we have to find pIndex
		int pIndex = start; // set pIndex as starting index initially
		for (int i=start;i<end;i++) {
			if (list.get(i) <= pivot) {
				// swap if element is lesser than pivot
				int temp = list.get(i);
				list.set(i, list.get(pIndex));
				list.set(pIndex, temp);
				pIndex++;
			}
		}
		// finally swap pivot with element at pIndex
		int temp = list.get(pIndex);
		list.set(pIndex, pivot);
		list.set(end, temp);
		
		// return pIndex
		return pIndex;
	}
}
