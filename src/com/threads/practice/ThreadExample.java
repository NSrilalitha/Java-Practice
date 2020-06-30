package com.threads.practice;

public class ThreadExample {

	public static void main(String[] args) throws InterruptedException {
	
		// print main thread name
		System.out.println(Thread.currentThread());
		Thread current = Thread.currentThread();
		current.setName("main thread");
		System.out.println("after renaming......."+current.getName());
		System.out.println("main thread priority...."+current.getPriority());
		// will check ThreadGroup of main thread
		System.out.println("ThreadGroup of main thread : "+current.getThreadGroup().toString());
		
		// Create object for child thread
		MyThread t1 = new MyThread();
		System.out.println("child thread priority......"+t1.getPriority());
		// set least priority for child thread, so main thread gets executed first
		//t1.setPriority(1);
		//System.out.println("child thread new priority....."+t1.getPriority());
		t1.start();
		System.out.println("ThreadGroup of t1 thread is :"+t1.getThreadGroup().toString());
		
		// print even numbers
		for(int i=1;i<10;i++) {
			if (i%2==0) {
				System.out.println("main thread");
				System.out.println(i);
				Thread.currentThread().yield();
			}
		}

		
		System.out.println("========Creation of thread using Runnable interface========");
		// using lambda expressions to provide implementation for run method of Runnable interface
		Thread t2 = new Thread(() -> System.out.println("inside run method of Runnable interface"));
		// starting t2 thread
		t2.start();
		
		// know ThreadGroup information
		ThreadGroup threadGroup = t2.getThreadGroup();
		System.out.println("ThreadGroup : "+threadGroup);
		System.out.println("active count: " + threadGroup.activeCount());
		System.out.println("is Daemon : "+threadGroup.isDaemon());
	}

}

/**
 * create Thread class
 * 
 * @author Srilalitha
 *
 */
class MyThread extends Thread {
	
	public void run() {
		
		// this thread prints odd numbers
		for(int i=1;i<10;i++) {
			if(i%2!=0) {
				System.out.println("child thread");
				System.out.println(i);
			}
		}
	}
}
