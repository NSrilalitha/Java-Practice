package com.threads.practice;

/**
 * lets create two threads to print even and odd numbers. lets print them in
 * even numbers first and then followed by odd numbers
 * 
 * @author Srilalitha
 *
 */
public class EvenThread {

	public static void main(String[] args) {
		
		// main is the main thread which starts by JVM
		System.out.println("In main method");
		System.out.println("===demo on join=====");
				
		// Now create a child thread t1. Its task is to print even numbers
		Thread t1 = new Thread(() -> printEvenNumbers());
		
		// lets create another thread. Its task is to print odd numbers
		Thread t2 = new Thread(() -> { 
			try {
				// Now apply join method on t1 thread. So t2 should wait till t1 completes its execution
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			printOddNumbers();
		});
		
		// start t1 thread
		t1.start();
		// start t2 thread
		t2.start();
		
	}

	// prints even numbers. 
	private static void printEvenNumbers() {
		for (int i=1;i<=10;i++) {
			if (i%2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	// prints odd numbers
	private static void printOddNumbers() {	
		for (int i=1;i<=10;i++) {
			if (i%2 == 1) {
				System.out.print(i + " ");
			}
		}
	}
}


