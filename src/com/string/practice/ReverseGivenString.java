package com.string.practice;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * This class illustrates the possible ways to reverse a string
 */
public class ReverseGivenString {

    public static void main(String[] args) {

        // string to be reversed
        String str = "hello";

        // Method-1: using StringBuilder
        StringBuilder sb = new StringBuilder();
        int len = str.length();

        for(int i=len-1;i>=0;i--) {
            sb.append(str.charAt(i));
        }
        String reversed = sb.toString();
        System.out.println(reversed);

        // Method-2: Using built in function of StringBuilder
        System.out.println(new StringBuilder(str).reverse().toString());

        // Method-3: Using Recursion
        ReverseGivenString ob = new ReverseGivenString();
        System.out.println("reversed string using recursion " +ob.reverse(str));

        // Method-4: Using a char array and reverse the array in place.
        char[] arr = str.toCharArray();

        int first = 0,last = len-1;
        while(first < last) {
            char temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }

        System.out.println("reversed string using char array is "+ new String(arr));

        // Method-5: Using java 8 streams
        String rev = str.chars()  // Convert to IntStream (stream of ASCII values)
                .mapToObj(c -> (char)c)  // Convert the IntStream to Stream<Character>
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            StringBuilder sb1 = new StringBuilder();
                            list.forEach(sb1::append);  // Append characters to StringBuilder
                            return sb1.reverse().toString();  // Reverse and return the string
                        }
                ));
        System.out.println("reversed string using java 8 streams is "+rev);

        // Method-6: Using java 8 streams with some alterations
        String reversedStr = str.chars()  // Convert to IntStream (stream of ASCII values)
                .mapToObj(c -> (char) c)  // Convert the IntStream to Stream<Character>
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),  // Collect characters into a list
                        list -> {
                            Collections.reverse(list);  // Reverse the list
                            return list.stream()
                                    .map(String::valueOf)  // Convert characters back to strings
                                    .collect(Collectors.joining());  // Join the characters back into a string
                        }
                ));
        System.out.println("reversed string using java 8 streams "+ reversedStr);
    }

    /*
    This method reverses the given string recursively
     */
    private String reverse(String s) {
        // base case: if string is empty, return string itself
        if(s.isEmpty()) {
            return s;
        }
        // recursive case: Take the substring starting from index 1, append the first character at the end
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
