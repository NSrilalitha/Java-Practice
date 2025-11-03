package com.sorting.practice;

import java.util.Arrays;

/**
 * Merge sort all cases O(nlogn) and space complexity is O(n) i.e., it needs extra space
 * Divide and Conquer approach
 * @author Srilalitha Nittala
 *
 */
public class MergeSortExample {

    public static void main(String[] args) {
        //sort the array in ascending order using Merge sort
        int[] arr = new int[]{1,5,2,7,4,3,8};

        System.out.println("Given array : "+ Arrays.toString(arr));

        // sort the given array
        mergeSort(arr,0,arr.length-1);

        System.out.println("Sorted array : "+Arrays.toString(arr));
    }

    // This method sorts the given array by divide and Conquer approach using merge sort
    private static void mergeSort(int[] arr, int left, int right) {

        if(left < right) {
            int mid = (left+right)/2;

            // conquer : recursively divide the array until array size becomes 1
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);

            // now combine the left and right arrays to get sorted array
            merge(arr,left,mid,right);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid-left+1;
        int n2 = right-mid;

        // create two temporary arrays for merging
        int[] L = new int[n1];
        int[] R = new int[n2];

        // copy the array elements to left and right arrays
        for(int i=0;i<n1;i++) {
            L[i] = arr[left+i];
        }
        for(int j=0;j<n2;j++) {
            R[j] = arr[mid+1+j];
        }

        // now combine the two arrays and rewrite the arr with sorted order
        int i=0,j=0,k=left;
        while(i<n1 && j<n2) {
            if(L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // now copy the remaining elements of L array
        while (i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
