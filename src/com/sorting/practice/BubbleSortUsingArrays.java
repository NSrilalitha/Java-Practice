package com.sorting.practice;

/**
 * This class sorts the array of strings using Bubble sort.
 *
 * worst case time complexity: o(n) so better to check no of swaps 0 i.e., array is already sorted or not to continue further
 * average and worst case time complexity:o(n2)
 *
 * Bubble sort is stable. i.e., while sorting it preserves the order
 */
public class BubbleSortUsingArrays {

    public static void main(String[] args) {

        String[] words = {"lalitha", "santosh", "achyutha", "sriram", "sri", "jayanthi", "jayanthi", "murthi", "lakshmi"};

        // sorting logic
        int numOfSwaps = 0;
        int n = words.length;
        for(int i=0;i<n;i++) {
            for(int j=n-1;j>i;j--) {
                if(words[j].compareTo(words[j-1]) < 0) {
                    // now swap those adjacent words
                    String temp = words[j];
                    words[j] = words[j-1];
                    words[j-1] = temp;
                    numOfSwaps++;
                }
            }
            // after 1 complete traversal numOfSwaps zero i.e., if list is already sorted come out of loop to avoid further comparisons
            if (numOfSwaps == 0)  {
                break;
            }
        }

        System.out.println("Sorted Array");
        for (String word : words) {
            System.out.print(word+ " ");
        }
    }
}
