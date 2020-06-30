package com.linkedlist.practice;

public class ReverseLinkedList {

	public static void main(String[] args) {
		
		Node n1 = new Node(10);
		Node n2 = new Node(52);
		Node n3 = new Node(12);
		Node n4 = new Node(90);
		
		// linked list should be 10->52->12->90
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		// Now print linked list elements before reversing
		System.out.println("==================before reversal==============");
		printLinkedList(n1);
		System.out.println();
		
		// reverse linked list. This will return new head element after reversal.
		Node newHead = reverse(n1);
		
		// Print linked list elements after reversing. Pass new Head as argument
		System.out.println("==================after reversal==============");
		printLinkedList(newHead);
	}
	
	/*
	 * This method reverses the linked list.
	 */
	private static Node reverse(Node head) {
		Node prev = null;
		Node current = head;
		Node next = null;
		
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		// prev indicates new head after reversal
		return prev;
	}

	/**
	 * This method prints linked list traverses from head element.
	 * 
	 * @param head
	 */
	private static void printLinkedList(Node head) {
		// traverse from head to tail
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	static class Node {
		int data;
		Node next;
		
		Node(int temp) {
			data = temp;
			next = null;
		}
	}
	
	
}
