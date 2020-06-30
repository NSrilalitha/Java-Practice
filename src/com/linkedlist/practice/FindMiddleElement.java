package com.linkedlist.practice;

/**
 * There are two ways to solve this problem. 
 * Approach-1: 
 * 1. we need to iterate through list twice. one for finding count to calcute middle position 2. After
 * calculation middle position again we have to iterate through the list till
 * middle position to find middle element
 * 
 * Approach-2: 1. We need two pointers 2. one pointer should traverse through
 * list by incrementing one time 3. Another pointer should traverse through list
 * by incrementing twice. 4. at the end of traversal first pointer indicates
 * middle element.
 *
 * @author Srilalitha
 *
 */
public class FindMiddleElement {

	static Node head;
	static Node current;
	
	public static void main(String[] args) {
		
		// Creating linked list 10->20->30->40->50
		Node node1 = new Node(10);
		Node node2 = new Node(20);
		Node node3 = new Node(30);
		Node node4 = new Node(40);
		Node node5 = new Node(50);
		Node node6 = new Node(60);
		Node node7 = new Node(70);
		Node node8 = new Node(80);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		
		// Assigning node1 as head element
		head = node1;
		
		// print list
		System.out.println("==========Printing list==========");
		printList(node1);
		
		// Now find middle element using approach1
		findMiddleElementV1(head);
		
		// Now find middle element using approach2
		findMiddleElementV2(head);
			
	}
	
	/**
	 * This method prints middle element using Approach-2.
	 * 
	 * @param headElement
	 */
	private static void findMiddleElementV2(Node headElement) {
		System.out.println("*************Approach-2***************");
		// we need two pointers to traverse the list
		Node slow_pointer = headElement;
		Node fast_pointer = headElement;
		
		while (fast_pointer != null && fast_pointer.next != null) {
			slow_pointer = slow_pointer.next;
			fast_pointer = fast_pointer.next.next;
		}
		// At end of traversal, slow pointer indicates middle element
		Node mid = slow_pointer;
		System.out.println("=========Middle element=======");
		System.out.println(mid);		
	}

	/**
	 * This method prints middle node of a linked list using Approach-1.
	 * 
	 * @param headElement
	 */
	private static void findMiddleElementV1(Node headElement) {
		System.out.println("*************Approach-1***************");
		// find length of list
		int length = findLengthOfList(headElement);
		// middle position
		int middlePosition = length / 2;
		System.out.println("Middle position is : " + middlePosition);
		// Now iterate through list till middlePosition and find middle element
		Node mid = null;
		current = headElement;
		int count = 0;
		while (current != null) {
			if (count == middlePosition) {
				mid = current;
			}
			current = current.next;
			count++;
		}
		// Now print middle element
		System.out.println("=========Middle element========");
		System.out.println(mid);
		
		// Note: If there are even nodes in the list then there will be two middle element
		// we need to print second middle element as mid
	}

	// finds length of given linked list
	private static int findLengthOfList(Node headElement) {
		// find list length by traversing through list
		int length = 0;
		current = headElement;
		while (current != null) {
			current = current.next;
			length++;
		}
		System.out.println("Length of list is : " + length);
		return length;

	}

	// creating static inner class Node
	static class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
	}
	
	// print list
	static void printList(Node headElement) {
		current = headElement;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
		
	}
}
