package com.sorting.practice;

/**
 * This class sorts the array of strings using Bubble sort.
 *
 * worst case time complexity: o(n2) so better to check no of swaps 0 i.e., array is already sorted or not to continue further
 * average and worst case time complexity:o(n2)
 *
 * Bubble sort is stable. i.e., while sorting it preserves the order of same elements
 */
public class BubbleSortUsingArrays {

    public static void main(String[] args) {

        String[] words = {"lalitha", "santosh", "achyutha", "sriram", "sri", "jayanthi", "jayanthi", "murthi", "lakshmi"};

        // sorting logic
        int n = words.length;
        for(int i=0;i<n-1;i++) {
            int numOfSwaps = 0; // reset each outer iteration
            for(int j=0;j<n-i-1;j++) {
                if(words[j].compareTo(words[j+1]) > 0) {
                    // now swap those adjacent words
                    String temp = words[j];
                    words[j] = words[j+1];
                    words[j+1] = temp;
                    numOfSwaps++;
                }
            }
            // if no swaps occurred in this pass, array is already sorted
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
