
package com.java8.features.practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Input  : {2,5,3,1,4,6}
Target : 7
output :{{2,5} {1,6} {3,4}

 */

public class TwoSum {

    public static void main(String[] args) {

        // Given list
        List<Integer> nums = new ArrayList<>(Arrays.asList(8,2,3,7,4,6,8,2));
        int target = 10;

        //Approach-1: for i<j, i+j==target, add pair [i,j] to the result list
        // This is O(N2) time complexity solution (stream nested loops - bruteforce solution)
        Set<List<Integer>> result = nums.stream()
                .flatMap(i -> nums.stream()
                                         .filter(j -> i<j && i+j==target)
                                         .map(j -> List.of(i,j)))
                .collect(Collectors.toSet());

        System.out.println(result);

        // Approach-2: HashSet based solution, efficient than Approach-1
        // This is O(N) time complexity solution
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> pairs = nums.stream()
                .filter(num -> {
                    if (seen.contains(target-num)) return true;
                    seen.add(num);
                    return false;
                })
                .map(num -> List.of(Math.min(num, target-num), Math.max(num, target-num)))
                .collect(Collectors.toSet());

        System.out.println(pairs);

        // Approach-3: Finding indices of pairs that sum to given target
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> indices = new HashSet<>();

        IntStream.range(0, nums.size()).forEach(i -> {
            int num = nums.get(i);
            int comp = target - num;

            if (map.containsKey(comp)) {    // complement exists
                indices.add(List.of(map.get(comp), i)); // correct pairing
            }
            map.put(num, i); // store current index for future matches
        });

        System.out.println(indices);

    }
}