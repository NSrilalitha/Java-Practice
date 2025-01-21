package com.string.practice;

/**
 * This class illustrates possible ways to find length of given string without using built-in functions.
 */
public class FindStringLength {

    public static void main(String[] args) {

        String str = "hello world";

        // Method-1: Using a char array and foreach loop
        System.out.println("Method-1: Using a char array and foreach loop");
        System.out.println("===============================================");
        char[] arr = str.toCharArray();
        int length = 0;
        for(char ch: arr) {
            length++; // increment length variable while iterating each character
        }
        System.out.println("length of the given string is "+length);

        // Method-2: Using split method
        // split the string into individual characters and then count the length of the resulting array.
        System.out.println("Method-2: Using split method");
        System.out.println("=============================");
        String[] arr1 = str.split("");
        for(String s : arr1) {
            System.out.println(s);
        }
        System.out.println("length of given string using split method is "+ arr1.length);

        // Method-3: Using recursion
        //  The recursive approach works by reducing the string step-by-step until the string is empty (base case), and in each step, it counts one character.
        System.out.println("Method-3: Using recursion");
        System.out.println("===========================");
        FindStringLength ob = new FindStringLength();
        System.out.println("length of the given string using recursion approach is "+ob.findLength(str));

        // Method-4: using iterative approach
        System.out.println("Method-4: using iterative approach");
        System.out.println("===================================");
        // make use of StringIndexOutOfBoundsException, when try to access an index out of bounds
        int count = 0;
        try {
            // Keep accessing characters one by one
            while(true) {
                str.charAt(count); // Try to access the character at index `count`
                count++; // If successful, increment the count
            }
        } catch(StringIndexOutOfBoundsException exception) {
            // When the index is out of bounds, exit the loop
        }
        System.out.println("length of given string is "+count);

    }

    private int findLength(String str) {
        // base case : is string is empty return 0
        if(str.isEmpty()) {
            return 0;
        }
        // recursive case : Remove the first character and call findLength again
        return 1 + findLength(str.substring(1));
    }
}
