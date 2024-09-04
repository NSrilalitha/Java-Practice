package com.java.collection.framework.practice;

import java.util.PriorityQueue;

/**
 * Refer : https://www.geeksforgeeks.org/priority-queue-class-in-java/
 */
public class PriorityQueueDemo {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(5);
		pq.add(4);
		pq.add(1);
		pq.add(3);
		pq.add(2);
		
		// Note: We will not get sorted elements by printing PriorityQueue.
		System.out.println(pq);
		
		// print head value -> poll() method returns the head which is least element in the queue.
		System.out.println(pq.poll());
		
		System.out.println(pq);	
		
	}

}
