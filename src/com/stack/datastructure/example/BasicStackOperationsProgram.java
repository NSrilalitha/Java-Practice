package com.stack.datastructure.example;

import java.util.Arrays;

/**
 * Implementing stack using array i.e., stack with bounded capacity.
 * 
 * @author Srilalitha
 *
 */
public class BasicStackOperationsProgram {

	private int[] arr;
	private int size;
	private int top;
	
	public static void main(String[] args) {
		BasicStackOperationsProgram stack = new BasicStackOperationsProgram(5);
		System.out.println("===============================");
		System.out.println("Adding elements to the stack");
		try {
			// add elements to the stack
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(10);
			stack.push(15);
			stack.push(9);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("=============================");
		// print stack elements
		System.out.println("stack elements are as follows");
		System.out.println(Arrays.toString(stack.arr));
		
		System.out.println("=================================");
		try {
			System.out.println("top element of the stack is "+stack.peek());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("===========================");
		System.out.println("size of the stack is "+stack.sizeOfStack());
		
		
		System.out.println("===========================");
		System.out.println("Check whethe given element present in stack or not");
		System.out.println("element 7 present or not :"+ stack.findElement(7));
		
		System.out.println("============================");
		System.out.println("print elements in insertion order");
		for (int i=0;i<stack.sizeOfStack();i++) {
			System.out.println(stack.arr[i]);
		}
		
		System.out.println("===========================");
		System.out.println("print elements from top to bottom");
		for (int i=stack.sizeOfStack()-1;i>=0;i--) {
			System.out.println(stack.arr[i]);
		}
		
		System.out.println("===============================");
		System.out.println("Removing elements from stack");
		try {
			// remove elements from the stack
			stack.pop();
			stack.pop();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		
		System.out.println("===============================");
		System.out.println("Now size of the stack is "+ stack.sizeOfStack());
		
	}
	
	/**
	 * Initializing the stack
	 * 
	 * @param size
	 */
	public BasicStackOperationsProgram(int size) {
		this.size = size;
		arr = new int[size];
		top = -1;
	}
	
	/**
	 * Adds element to the stack. If stack is full throws exception
	 * 
	 * @param entry
	 * @throws Exception
	 */
	public void push(int entry) throws Exception {
		// during overflow state it throws exception
		
		// if stack is full throw exception
		if(isStackFull()) 
			throw new Exception("Stack is full. Can't add element to the stack");
		
		System.out.println("adding element :"+entry);
		arr[++top] = entry;
	}
	
	/**
	 * Removes element from stack. If stack is empty then throws exception
	 * 
	 * @return
	 * @throws Exception
	 */
	public int pop() throws Exception {
		// during underflow state it throws exception
		
		// if stack is empty throw exception
		if(isStackEmpty()) 
			throw new Exception("Stack is empty. Can't remove any element from the stack");
		
		int element = arr[top--];
		System.out.println("removed element is "+element);
		return element;
	}
	
	/**
	 * Retrieves element from stack. If stack is empty then throws exception.
	 * 
	 * @return
	 * @throws Exception
	 */
	public int peek() throws Exception {
		
		// if stack is empty throw exception
		if(isStackEmpty()) 
			throw new Exception("Stack is empty. Can't retrieve any element from the stack");
				
		return arr[top];
	}
	
	/**
	 * checks stack is full or not
	 * 
	 * @return
	 */
	public boolean isStackFull() {
		if(top == size - 1) return true;
		return false;
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
	
	/**
	 * gives size of stack
	 * @return
	 */
	public int sizeOfStack() {
		return top+1;
	}
	
	/**
	 * Check whether given element present in the stack or not
	 * 
	 * @param element
	 * @return
	 */
	public boolean findElement(int element) {
		for (int i=top; i>=0; i--) {
			if (arr[top] == element) 
				return true;
		}
		return false;
	}

}
