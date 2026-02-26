package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Move All Zeros to End (Maintain Order)
 *
 * Input:
 * [1, 0, -3, 0, 5, -2, 0, 8, 0, -1]
 * Output:
 * [1, -3, 5, -2, 8, -1, 0, 0, 0, 0]
 *
 * One of the most common interview coding questions:
 * 👉 Rearrange the list so that all 0s move to the end
 * 👉 Preserve the order of other elements (Stable Partition)
 */
public class MoveZerosToEnd {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 0, -3, 0, 5, -2, 0, 8, 0, -1};

        // Approach-1:
        // Two-pointer approach - O(N) optimal solution
        int nonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex] = arr[i];
                nonZeroIndex++;
            }
        }
        while(nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
        System.out.println(Arrays.toString(arr));

        // Approach-2: Using java 8 streams API
        // case-1: Taking primitive integer array
        int[] arr1 = new int[]{1, 0, -4, -6, 5, 0, 0, 8, 0, -2};
        List<Integer> list = IntStream.concat(
                Arrays.stream(arr1).filter(n -> n != 0),
                Arrays.stream(arr1).filter(n -> n==0)
                                    ).boxed() //wraps primitive int values into Integer objects.
                                    .collect(Collectors.toList());
        System.out.println(list);

        // case-2: Taking input as list of integers
        List<Integer> numbers = List.of(1,-5,0,2,-7,0,4,3,0,2,-1,0);
        List<Integer> list1 = Stream.concat(
                                        numbers.stream().filter(n -> n != 0),
                                        numbers.stream().filter(n -> n==0)
                                    ).toList();
        System.out.println(list1);
    }
}
