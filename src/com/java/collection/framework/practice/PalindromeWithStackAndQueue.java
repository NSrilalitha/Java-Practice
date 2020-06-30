package com.java.collection.framework.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Given a String S, find it is palindrome or not using stack and queue.
 * 
 * To solve this challenge, we must first take each character in S, enqueue it
 * in a queue, and also push that same character onto a stack. Once that's done,
 * we must dequeue the first character from the queue and pop the top character
 * off the stack, then compare the two characters to see if they are the same;
 * as long as the characters match, we continue dequeueing, popping, and
 * comparing each character until our containers are empty (a non-match means
 * isn't a palindrome).
 * 
 * @author Srilalitha
 *
 */
public class PalindromeWithStackAndQueue {

	// creating static stack. Stack is a class available in java.util package
	static Stack<Character> stack = new Stack<>();

	// creating static Queue. Queue is an interface. LinkedList is one of the
	// implementation class for Queue interface.
	static Queue<Character> queue = new LinkedList<>();
	
	static Queue<Character> pqueue = new ConcurrentLinkedQueue<>();
			
	public static void main(String[] args) {
		
		String str = "madam";
		// find given str is palindrome or not
		
		// converting string to char array
		char[] arr = str.toCharArray();
		
		// add each character in array to stack and queue
		// Stack works on LIFO Last In First Out
		// Queue works on FIFO First In First Out
		for (char ch: arr) {
			// push character to stack
			pushCharacter(ch);
			// enqueue character (Add) to queue
			enqueueCharacter(ch);	
		}
		
		// Now will retrieve each character from stack and queue and compare if they are
		// same or not. Stack retrieves the characters from last to first (i.e., reverse)
		// queue retrieves the characters from first to last .
		boolean isPalindrome = true;	
		for (int i=0;i<arr.length/2;i++) {
			if (popCharacter() != dequeueCharacter()) {
				isPalindrome = false;
				break;
			}	
		}
		
		if (isPalindrome) {
			System.out.println(str + " is Palindrome");
		} else {
			System.out.println(str + " is not Palindrome");
		}
	}

	// retrieves character from Queue
	private static Character dequeueCharacter() {
		// peek method will return the character but doesn't remove
		// poll method will return and remove the character from queue
		// when we try to retrieve element from Queue, it retrieves elements in FIFO order
		return queue.peek();
	}

	// retrieves character from stack
	private static Character popCharacter() {
		// peek method will return the character from Stack
		// pop will retrieve the character from stack and deletes it in stack
		// when we try to retrieve element from Stack, it retrieves elements in LIFO order
		return stack.peek();
	}

	// add character to Queue
	private static void enqueueCharacter(char ch) {
		queue.offer(ch);
	}

	// add character to stack using push method
	private static void pushCharacter(char ch) {
		stack.push(ch);
	}
}
