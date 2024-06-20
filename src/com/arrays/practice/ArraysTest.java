package com.arrays.practice;

import java.util.Arrays;

public class ArraysTest {

    public static void main(String[] args) {

        // single dimensional array
        int[] a = {10,20,30,40,50,60,70,80,90};
        System.out.println(a); // this will print string representation of array object
        // it internally calls Object class toString method

        // now print array values
        System.out.println(Arrays.toString(a));

        // multidimensional array
        int[][] a1 = new int[][]{{10, 40, 60}, {30, 20}};
        System.out.println(a1);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a1[0]));
        System.out.println(Arrays.toString(a1[1]));
        // System.out.println(Arrays.toString(a1[2])); // this line gives ArrayIndexOutOfBoundsException
        System.out.println(a1[0][0]);
    }
}
