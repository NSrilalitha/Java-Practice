package com.linkedlist.practice;

/**
 * Creating linked list from scratch - refer https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 */
public class CreateLinkedListFromScratch {

	static Node head;
	static Node current;
	
	public static void main(String[] args) {
		// create a linked list 52->10->74->33->15
		// insert elements into linked list
		insert(new Node(52));
		insert(new Node(10));
		insert(new Node(74));
		insert(new Node(33));
		insert(new Node(15));
		
		// print linked list
		printElements(head);
		
		// reverse linked list
		Node newHead = reverseList(head);
		System.out.println();
		
		// print reversed linked list
		printElements(newHead);
	}
	
	// create Node class
	static class Node {
		
		int data;
		Node next;
		
		Node(int element) {
			data = element;
		}
	}
	
	/**
	 * Insert elements into the list from scratch
	 * 
	 * @param newNode
	 */
	private static void insert(Node newNode) {
		if (current == null) {
			current = newNode;
			head = newNode;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			// now assign newNode 
			current.next = newNode;
		}
	}
	
	/*
	 * print elements in linked list
	 */
	private static void printElements(Node headElement) {
		current = headElement;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}
	
	/*
	 * reverse linked list and returns new Head
	 */
	private static Node reverseList(Node head) {
		Node prev = null;
		Node nextElement = null;
		Node currentElement = head;
		while (currentElement != null) {
			nextElement = currentElement.next;
			currentElement.next = prev;
			prev = currentElement;
			currentElement = nextElement;
		}
		// prev indicates new Head element in reverse direction
		return prev;
	}
	
}
