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

        // sorts the numbers in descending order
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
        // sort the numbers in descending order
        for(int i=1;i<n;i++) {
            int key = arr[i]; // element to be inserted in sorted part at correct position
            int j = i-1;

            while(j>=0 && arr[j] < key) {
                arr[j+1] = arr[j];
                j--;
            }
            // insert key at correct position
            arr[j+1] = key;
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
        for(int i=1;i<n;i++) {
            String key = words[i];
            int j = i-1;

            while(j>=0 && words[j].compareTo(key) > 0) {
                words[j+1] = words[j]; // shift by 1 position right side
                j--;
            }
            // insert key in correct position
            words[j+1] = key;
        }

        // print sorted array
        System.out.println("sorted array as follows");
        for(String word: words) {
            System.out.print(word + " ");
        }
    }

}
