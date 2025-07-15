package com.string.practice;

/**
 * Given an array of strings, find the longest string that is a prefix of all the strings in the array. If there is no common prefix, return an empty string.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        // Input: ["flower", "flow", "flight"] , Output: "fl"

        String[] arr = {"dog","racecar","car"};//{"flower", "flow", "flight"};

        // Approach-1: Horizontal scanning
        System.out.println(findLCPUsingHorizontalScanning(arr));

        // Approach-2: Vertical scanning - here we compare each letter of the strings one by one and compare
        System.out.println(finLCPUsingVerticalScanning(arr));

        // Approach-3: divide and conquer approach
        System.out.println(findLCPUsingDivideAndConquer(arr));

    }

    /*
    We can divide the array of strings into two halves, find the longest common prefix for each half, and
then merge the results. This is similar to the merge sort approach.
     */
    // Time complexity : `O(S)` where `S` is the sum of the lengths of all strings
    // space complexity : O(log n): For recursion depth (stack space)
    private static String findLCPUsingDivideAndConquer(String[] arr) {
        if(arr == null || arr.length == 0) {
            return "";
        }
        return divideAndConquer(arr,0,arr.length-1);
    }

    // Helper function to divide the array and conquer
    private static String divideAndConquer(String[] arr, int left, int right) {
        // base case : If there's only one string, return it
        if(left == right) {
            return arr[left];
        }
        // recursive case : Split the array of strings into two halves. Recursively find the longest common prefix of each half, and then find the common prefix between the two results.
        int mid = (left + right)/2;
        String leftPrefix = divideAndConquer(arr,0,mid);
        String rightPrefix = divideAndConquer(arr,mid+1,right);

        // Combine the results by finding the common prefix of both halves
        return commonPrefix(leftPrefix,rightPrefix);
    }

    // Helper function to find the common prefix of two strings
    private static String commonPrefix(String str1, String str2) {
        int minLength = Math.min(str1.length(),str2.length());
        for(int i=0;i<minLength;i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0,i);
            }
        }
        return str1.substring(0, minLength);
    }

    /*
    In this approach, we check character by character across all strings column by column. We stop as soon
as we find a mismatch or reach the end of one of the strings.
     */
    private static String finLCPUsingVerticalScanning(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            //If all strings have the same character at the current index, continue; otherwise, return the prefix up
            // to that point.
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /*
    In this approach, we compare strings one by one, iterating through the array and constantly reducing
the prefix until we find the longest common prefix for all strings.
     */
    private static String findLCPUsingHorizontalScanning(String[] arr) {
        if(null == arr || arr.length == 0) {
            return "";
        }

        // consider first string as prefix
        String prefix = arr[0];
        // compare it with further strings in the array
        for(int i=1;i<arr.length;i++) {
            // Reduce the prefix to match current string
            while(arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) {
                    prefix = "";
                }
            }
        }
        return prefix;
    }
}
