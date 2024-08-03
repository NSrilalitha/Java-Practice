package com.sorting.practice;

import java.util.Arrays;

/**
 * Insertion sort is a stable and in-place sorting algorithm.
 *
 * Time complexity: worst case and average case: O(n*2), best case - O(n)
 * space complexity: O(1)
 */
public class InsertionSortUsingArrays {

    public static void main(String[] args) {

        // numbers to be sorted
        int[] arr = { 71, 23, 46, 32, 11, 98, 7 };

        // Strings to be sorted
        String[] words = {"lalitha", "sri", "sriram", "achyutha", "santosh", "jayanthi"};

        // creating instance to call sorting method
        InsertionSortUsingArrays sorter = new InsertionSortUsingArrays();

        // sorts the numbers
        sorter.insertionSort(arr);

        System.out.println();
        // sorts the strings
        sorter.insertionSort(words);

    }

    /**
     *  This method sorts the numbers of integer type
     */
    public void insertionSort(int[] arr) {
        System.out.println("Given array: "+Arrays.toString(arr));
        // SORTING LOGIC STARTS HERE
        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            for (int j= i+1;j>0;j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        // print sorted array
        System.out.println("sorted array as follows");
        for(int num: arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * This method sorts the strings in lexicographical order.
     * We are using method overloading concept here.
     */
    public void insertionSort(String[] words) {
        System.out.println("Given array of words :"+ Arrays.toString(words));
        int n = words.length;
        for(int i=0;i<n-1;i++) {
            for (int j= i+1;j>0;j--) {
                if (words[j].compareTo(words[j-1]) < 0) {
                    String temp = words[j];
                    words[j] = words[j-1];
                    words[j-1] = temp;
                }
            }
        }

        // print sorted array
        System.out.println("sorted array as follows");
        for(String word: words) {
            System.out.print(word + " ");
        }
    }

}
