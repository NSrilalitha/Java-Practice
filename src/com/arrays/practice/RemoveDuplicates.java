package com.arrays.practice;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the
 * duplicates in-place such that each unique element appears only once. The
 * relative order of the elements should be kept the same. Then return the
 * number of unique elements in nums.
 * 
 * Consider the number of unique elements of nums to be k, to get accepted, you
 * need to do the following things:
 * 
 * Change the array nums such that the first k elements of nums contain the
 * unique elements in the order they were present in nums initially. The
 * remaining elements of nums are not important as well as the size of nums.
 * Return k.
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2] 
 * Output: 2, nums = [1,2,_] 
 * Explanation: Your function
 * should return k = 2, with the first two elements of nums being 1 and 2
 * respectively. It does not matter what you leave beyond the returned k (hence
 * they are underscores).
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = {1,1,2};
		System.out.println("Given array : "+Arrays.toString(nums));
		RemoveDuplicates ob = new RemoveDuplicates();
		int k = ob.removeDuplicates(nums);
		System.out.println("After removing duplicates array becomes : "+Arrays.toString(nums));
		System.out.println("k value : "+k);
	}
	
public int removeDuplicates(int[] nums) {
        
        int k=1;
        
		// since array is sorted the duplicates place next to it. so compare element
		// with its previous to check duplicate or not
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[k] = nums[i];
				k++;
			}
		}
        return k;
    }

}
