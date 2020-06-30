package com.linkedlist.practice;

public class RemoveLastNodeInLinkedList {

	static Node head;
	static Node current;
	static Node tail;
	
	public static void main(String[] args) {
		
		// lets create a linkedlist
		// creating list 10->20->30->40->50
		System.out.println("==========Adding elements to linkedlist=========");
		add(10);
		add(20);
		add(30);
		add(40);
		add(50);
		System.out.println("=============printing list==============");
		// print list
		print();
		System.out.println("===========head element===========");
		// print first element i.e., first element is always head
		System.out.println(head);
		System.out.println("==========tail element==========");
		// Now print last element of list i.e., tail
		Node lastElement = getTail();
		System.out.println(lastElement);
		System.out.println("==========Removing last node============");
		// Now remove last element from list
		removeLastNode();
		// Now print the list after removing and verify whether 50 is removed or not
		System.out.println("===========After removal==========");
		print();
		// Now print last element
		System.out.println(getTail());
		
		
	}
	
	// creating static inner class called Node
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
	
	// adding elements to Linkedlist
	static void add(int data) {
		if (head == null) {
			head = new Node(data);
			current = head;
		} else {
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(data);
		}
	}
	
	// printing elements in linkedlist
	static void print() {
		current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	// set last element as tail 
	static Node getTail() {
		current = head;
		while (current.next != null) {
			current = current.next;
		}
		tail = current;
		return tail;
	}
	
	// to remove last node, make next as null for last but not one node
	static void removeLastNode() {
		current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}
}


