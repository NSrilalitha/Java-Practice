/**
 * 
 */
package com.arrays.practice;

import java.util.Arrays;

/**
 * Given an array of integers arr, return true if and only if it is a valid
 * mountain array.
 * 
 * Recall that arr is a mountain array if and only if:
 * 
 * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] > ... >
 * arr[arr.length - 1]
 * 
 * Example 1:
 * Input: arr = [2,1] Output: false
 * 
 * Example 2:
 * Input: arr = [3,5,5] Output: false
 * 
 * Example 3:
 * Input: arr = [0,3,2,1] Output: true
 */
public class ValidMountainArray {

	public static void main(String[] args) {
		// input-1
		int[] arr = {0,3,2,1};
		// input-2
		int[] arr1 = {3,5,5};
		ValidMountainArray ob = new ValidMountainArray();
		boolean isValid = ob.validMountainArray(arr);
		System.out.println("Is given array "+Arrays.toString(arr)+" valid mountain array :"+isValid);
		System.out.println("Is given array "+Arrays.toString(arr1)+" valid mountain array :"+ob.validMountainArray(arr1));
		
	}
	
public boolean validMountainArray(int[] arr) {
        
        if(arr == null || arr.length <3) {
            return false;
        }
        
        int left = 0; // left pointer
        int right = arr.length-1; // right pointer
        
        // when two people are climbing the mountain from left and right they meet at the valley. i.e., whenever 
        // left and right pointers meet that is mountain valley point
        while(left+1 < arr.length-1 && arr[left+1]>arr[left]) {
            left++;
        }
        
        while(right-1 > 0 && arr[right-1]>arr[right]) {
            right--;
        }
        
        // edge case - if array is completely increased or array is completely decreased
        if(left == 0 || right == arr.length-1) {
            return false;
        }
        
        // if all the conditions checked then final check whether left and right pointers meet
        if (left == right) {
            return true;
        }
        
        return false;
      
    }

}
