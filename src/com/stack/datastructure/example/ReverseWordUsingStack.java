/**
 * 
 */
package com.stack.datastructure.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Reverse a word or string using stack.
 * 
 * @author Srilalitha
 *
 */
public class ReverseWordUsingStack {

	private char[] arr;
	private int size;
	private int top;
	
	public ReverseWordUsingStack(int length) {
		size = length;
		top = -1;
		arr = new char[size];
	}

	public static void main(String[] args) {
		
		// read String
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		// set size as length of word
		ReverseWordUsingStack stack = new ReverseWordUsingStack(word.length());
		// push word to stack
		for(int i=0;i<stack.size;i++) {
			stack.push(word.charAt(i));
		}
		// reverse word using stack
		try {
			
			while (!stack.isStackEmpty()) {
				System.out.print(stack.pop());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Adds element to the stack. If stack is full throws exception
	 * 
	 * @param entry
	 * @throws Exception
	 */
	public void push(char entry) {
		arr[++top] = entry;
	}
	
	/**
	 * Removes element from stack. If stack is empty then throws exception
	 * 
	 * @return
	 * @throws Exception
	 */
	public char pop() throws Exception {
		// during underflow state it throws exception
		
		// if stack is empty throw exception
		if(isStackEmpty()) 
			throw new Exception("Stack is empty. Can't remove any element from the stack");
		
		char element = arr[top--];
		return element;
	}
	
	/**
	 * checks stack is empty or not
	 * 
	 * @return
	 */
	public boolean isStackEmpty() {
		if(top == -1) return true;
		return false;
	}
	
}
