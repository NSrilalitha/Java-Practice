package com.linkedlist.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Remove duplicates in a linked list eg: if list is {1,2,2,3,4,4} remove
 * duplicates and result should be {1,2,3,4}
 * 
 * @author Srilalitha
 *
 */
public class RemoveDuplicatesUsingLinkedList {

	static Node head = null;
	static Node current = null;
	
	public static void main(String[] args) {
		
		// Now create linked list as {1,2,2,3,4,4}
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		// Now print list
		head = n1;
		printList();
		
		// Now remove duplicates
		removeDuplicates(head);
		System.out.println("printing list after removal of duplicate elements");
		printList();
		System.out.println(head);
	}
	
	// remove duplicate elements in linked list
	private static void removeDuplicates(Node headElement) {
		Node current = headElement;
		// prev is to keep track of previous elements
		Node prev = null;
		List<Integer> list = new ArrayList<>();
		
		while (current != null) {
			
			if (!list.contains(current.data)) {
				list.add(current.data);
				prev = current;
				current = current.next;
			} else {
				// since current is a duplicate node we have to remove current node. So changing prev node next reference to
				// current next reference. Then current node will be deleted.
				prev.next = current.next;
				// next current should indicate next to deleted element
				current = prev.next;
			}
		}
		
	}

	// creating static class Node
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	
	// print list
	static void printList() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}
