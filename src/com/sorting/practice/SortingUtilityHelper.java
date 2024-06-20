package com.sorting.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides frequently used operations/code for all kind of sorting algorithms.
 *
 */
public class SortingUtilityHelper {

    /**
     * This method is to create a sample input list for sorting operations
     */
    public static List<Integer> numbersList() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(32);
        list.add(8);
        list.add(57);
        list.add(12);
        list.add(89);
        return list;
    }

    /**
     * This method is to swap the elements present in given two indices
     */
    public static void swapIndexes(int j, int k, List<Integer> list) {
        int temp = list.get(j);
        list.set(j, list.get(k));
        list.set(k, temp);
    }
}
