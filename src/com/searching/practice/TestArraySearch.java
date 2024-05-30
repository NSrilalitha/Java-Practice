package com.searching.practice;

import java.util.Arrays;

/**
 * This program is to check Arrays binarySearch method and how it works
 */
public class TestArraySearch {
    public static void main(String[] args) {
        // declare an array
        int[] arr = {10,27,43,99,54,83,12};
        // without sorting the array, if we try to search any element we get incorrect results
        // check this scenario without sorting first
        //now I want to find the index of 54
        int index = Arrays.binarySearch(arr, 54);
        System.out.println("The number is at index " + index);

        // now sort the array to find the index of specified element, if it is not sorted the result is not correct
        Arrays.sort(arr);
        // now find the index of required element, we get correct index now
        //print sorted array
        System.out.println(Arrays.toString(arr));
        index = Arrays.binarySearch(arr, 54);
        System.out.println("The number is at index " + index);

        //scenario-2:
        int[] arr1 = {10,27,43,99,54,83,12,54,90,54,66};
        Arrays.sort(arr1);
        //print sorted array
        System.out.println(Arrays.toString(arr1));
        // now arr1 contains many numbers equals to 54. now check which index it will return
        index = Arrays.binarySearch(arr1, 54);
        System.out.println("The number is at index " + index);


    }
}
