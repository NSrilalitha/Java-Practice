package com.pattern.wise.problems.two.pointer.pattern;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given array with even and odd numbers. Rearrange even first then odd without creating
 * new array (in-place)
 *
 * If stability is not required → two pointers, O(N), in-place (best solution).
 *
 * If stability is required →
 * - In-place: O(N²) stable shifting using insertion sort
 * - With O(N) extra space: O(N) stable solution
 *
 * There is no O(N) stable in-place solution.
 */
public class FindEvenOddNumbers {

    public static void main(String[] args) {

        // Approach-1: Using Two pointer pattern,
        // which solves in O(N) time complexity, O(1) space complexity, in-place
        int[] arr = new int[]{1,3,2,5,6,8,9,10,4};
        System.out.println("Given array : "+Arrays.toString(arr));

        // two pointer approach
        int i=0;
        int j=arr.length-1;

        while(i < j) {
            if(arr[i]%2==0) i++;
            else if (arr[j]%2!=0) j--;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));


        // Approach-2: Using java 8 streams API, Using IntStream concat function

        // Using streams, you inevitably create new collections, because Streams are not meant
        // for in-place mutation. The goal is a clean, expressive solution, not O(1) space.
        int[] arr1 = new int[]{5,7,8,1,4,9};
        int[] result = IntStream.concat(
                Arrays.stream(arr1).filter(n -> n%2==0), // even first
                Arrays.stream(arr1).filter(n -> n%2==1) // odd next
        ).toArray();

        System.out.println(Arrays.toString(result));

        // Approach-3: Using java 8 streams API, Using by partitionBy
        List<Integer> list = new ArrayList<>(Arrays.asList(2,1,5,4,3,8,9,7,6));

        List<Integer> orderedList = list.stream().collect(Collectors.partitioningBy(n -> n%2==0))
                .entrySet().stream()
                .sorted(Map.Entry.<Boolean, List<Integer>>comparingByKey().reversed())// ensure true first
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());

        System.out.println(orderedList);

        // while sorting boolean, false always come first
        List<Integer> ordList = list.stream().collect(Collectors.partitioningBy(n -> n%2!=0))
                .entrySet().stream()
                .sorted(Map.Entry.<Boolean,List<Integer>>comparingByKey())// ensure true first
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());

        System.out.println(ordList);

    }
}
