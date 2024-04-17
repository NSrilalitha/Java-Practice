package com.stack.datastructure.example;

import java.util.*;

/**
 * 
 * Question: Given a string A consisting only of ’(‘ and ’)’.
 * 
 * You need to find whether parentheses in A is balanced or not ,if it is
 * balanced then print 1 else print 0.
 * 
 * Examples of some correctly balanced strings are: “()()”, “((()))”, “((()))”
 * 
 * Examples of some unbalanced strings are: “()(“, “(()))”, “((“, “)(“ etc.
 * 
 * SOLVE THE PROBLEM USING STACK
 * 
 * @Srilalitha
 */
public class BalancingParenthesisUsingStack {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number of testcases: ");
        int t = inp.nextInt();
        inp.nextLine();
        System.out.println("Enter words to test balanced parenthesis");
        while (t-- > 0) {
            String A = inp.nextLine();
            if (solve(A)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        inp.close();
    }
    public static boolean solve(String A) {
        Stack < Character > s = new Stack < > ();
        char[] expr = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            if (expr[i] == '(') {
                // Push the element in the stack
                s.push(expr[i]);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (s.empty())
                return false;

            if (expr[i] == ')') {
                // Store the top element in a
                char x = s.peek();
                s.pop();
                if (x != '(') {
                    return false;
                }
            }
        }

        // Check Empty Stack
        return (s.empty());
    }
}
