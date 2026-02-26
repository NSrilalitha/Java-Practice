package com.java8.features.practice;

/**
 * Problem Statement #
 * Given an array of positive numbers and a positive number ‘k,’
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * Example 1:
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2:
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaxSumSlidingWindow {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 1, 5, 1, 3, 2};
        int k = 3;

        int currentSum = 0;
        for(int i=0;i<k;i++) {
            currentSum += arr[i];
        }
        int maxSum = currentSum;
        for(int i=k;i<arr.length;i++) {

            currentSum += arr[i];
            currentSum -= arr[i-k];

            if(currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println("Max sum : "+maxSum);

    }
}
