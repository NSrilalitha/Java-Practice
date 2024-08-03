package com.arrays.practice;

import java.util.Arrays;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val
 * in nums in-place. The order of the elements may be changed. Then return the
 * number of elements in nums which are not equal to val.
 * 
 * Consider the number of elements in nums which are not equal to val be k, to
 * get accepted, you need to do the following things:
 * 
 * 1. Change the array nums such that the first k elements of nums contain the
 * elements which are not equal to val. The remaining elements of nums are not
 * important as well as the size of nums. 2. Return k.
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,2,3], val = 3 
 * Output: 2, nums = [2,2,_,_] 
 * Explanation:
 * Your function should return k = 2, with the first two elements of nums being
 * 2. It does not matter what you leave beyond the returned k (hence they are
 * underscores).
 * 
 */
public class RemoveAllOccurances {

	public static void main(String[] args) {
		int[] nums = {3,2,2,3};
		System.out.println("Given array : "+Arrays.toString(nums));
		// now remove all occurances of val=3
		RemoveAllOccurances ob = new RemoveAllOccurances();
		int k = ob.removeElement(nums, 3);
		System.out.println("Now the array becomes : "+Arrays.toString(nums));
		System.out.println("k value : "+k);

	}
	
public int removeElement(int[] nums, int val) {
        
        // to keep track of non-val elements in the array
        int k=0;
        
        //iterate through array 
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
