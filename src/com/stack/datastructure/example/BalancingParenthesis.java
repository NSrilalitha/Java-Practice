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

public class BalancingParenthesis {

	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Scanner sc = new Scanner(System.in);
		// read testcases number
		System.out.print("Enter number of testcases: ");
		int t = sc.nextInt();
		sc.nextLine();

		// declare stack
		Stack<String> words = new Stack<>();
		String word = " ";
		System.out.println("Enter words to test balanced parenthesis");
		for (int i = 1; i <= t; i++) {
			// read strings and add it to Stack
			words.push(sc.nextLine());
		}
		sc.close();

		// now result hold integer 1 or 0 to tell about balanced or not
		ArrayList<Integer> result = new ArrayList<>();

		int size1; // size1 holds count of '('
		int size2; // size2 holds count of ')'

		// now check this word has balanced parenthesis
		while (!words.empty()) {
			// check word is balanced or NOT
			word = words.peek(); // retrieve top word from stack and check
			if (word.startsWith(")")) {
				// if word starts with ')' then it indicates string is not balanced so we dont
				// check further
				result.add(0);
			} else {
				size1 = 0;
				size2 = 0;
				char[] arr = word.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == '(') {
						size1++;
					} else if (arr[i] == ')') {
						size2++;
					} else {
					}
				}
				// if both sizes i.e., starting and closing braces equal we can mention 1 i.e.,
				// balanced
				if (size1 == size2) {
					result.add(1);
				} else {
					result.add(0);
				}
			}
			// removing checked word from stack
			words.pop();
		}

		// now print result list in reverse order
		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.println(result.get(i));
		}

	}
}

// Another approach to solve this problem using stack refer https://www.javatpoint.com/balanced-parentheses-in-java

// solution approach
// Algorithm:
/**
 * 1. Declare a character stack S. 
 * 2. Now traverse the expression string exp.
 * 		2.1. If the current character is a starting bracket ‘(‘ then push it to
 * 			 stack. 
 * 		2.2. If the current character is a closing bracket ‘)’ then pop from
 * 			 stack and if the popped character is the matching starting bracket then fine
 * 			 else parenthesis are not balanced. 
 * 3. After complete traversal, if there is some starting bracket left in stack then “-1”
 * 
 * Time Complexity: O(len(A)) Auxiliary Space: O(len(A)) for stack.
 */
