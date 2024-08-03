package com.arrays.practice;

import java.util.Arrays;

/**
 * Problem: Given an integer array nums sorted in non-decreasing order, return
 * an array of the squares of each number sorted in non-decreasing order.
 * 
 * Example 1:
 * 
 * Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100] Explanation: After
 * squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes
 * [0,1,9,16,100].
 */
public class SortedSquares {

	public static void main(String[] args) {
		int[] arr = {-4,-1,0,3,10};
		// sort the squares of each element in given array using two pointer approach
		SortedSquares ob = new SortedSquares();
		int[] squares = ob.sortedSquares(arr);
		System.out.println(Arrays.toString(squares));
	}
	
	public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;

        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[start]) < Math.abs(A[end])) {
                result[i] = A[end] * A[end];
                end--;
            } else {
                result[i] = A[start] * A[start];
                start++;
            }
        }
        return result;
    }
}
