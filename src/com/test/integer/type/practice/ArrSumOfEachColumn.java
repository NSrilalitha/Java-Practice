package com.test.integer.type.practice;

import java.util.*;

/**
 * Problem: Print sum of elements in each column with space separation
 */
public class ArrSumOfEachColumn {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N : ");
        int N = sc.nextInt();
        System.out.println("Enter M : ");
        int M = sc.nextInt();
        sc.nextLine();
        int[][] arr = new int[N][M];
        
        
        System.out.println("Enter array values :");
        // now read matrix values
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                arr[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        //here print the array for testing
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        // sum array to hold sum of each column
        int[] sum = new int[M];
        
        // finding sum of each column
        for(int j=0;j<M;j++) {
            for(int i=0;i<N;i++) {
               sum[j] = sum[j] + arr[i][j];
            }
        }
        
        System.out.println("Sum of each column is as follows");
        // PRINT SUM values
        for(int k=0;k<M;k++) {
            System.out.print(sum[k] + " ");
        }   
        
        sc.close();
        
    }
}