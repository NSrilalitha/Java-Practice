package com.linkedlist.practice;


public class CreateLinkedList {

	public static void main(String[] args) {
		
		Node n1 = new Node(10);
		Node n2 = new Node(52);
		Node n3 = new Node(12);
		Node n4 = new Node(90);
		
		// linked list should be 10->52->12->90
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		// Now print linked list element
		printLinkedList(n1);
	}
	
	/*
	 * Create a Node class which represents node in linkedlist. This is inner static class, so that accessible by main method.
	 */
	static class Node {
		int data;
		Node next;
		
		/*
		 * Constructor to initialize node with values
		 */
		Node(int temp) {
			data = temp;
			next = null;
		}
	}
	
	/*
	 * Method to traverse the linked list and print elements
	 */
	private static void printLinkedList(Node current) {
		
		// traverse from current to tail
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		
	}
}
