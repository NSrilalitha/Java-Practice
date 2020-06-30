package com.threads.practice;

public class ThreadStateExample {

	// making main thread as static here, to access this thread in another threads to know the state
	static Thread main = null;
	
	public static void main(String[] args) {
		
		System.out.println("name of main thread is : "+Thread.currentThread().getName());
		main = Thread.currentThread();
		
		// ThreadGroup of main thread will be
		System.out.println("ThreadGroup for main thread is : "+main.getThreadGroup());
		
		// To know the state of Thread there is a static nested class State present in Thread class
		ThreadImpl t1 = new ThreadImpl();
		// when we create thread, it will be in NEW state
		System.out.println("after creating thread t1, thread state will be : "+t1.getState());
		// start thread
		t1.start();
		
		/*
		 * classloader for thread t1, Since t1 is instance of our custom class,
		 * ApplicationClassLoader loads this ThreadImpl class
		 * 
		 */
		System.out.println("classloader for thread t1 : " + t1.getClass().getClassLoader());

		/*
		 * Thread class is in predefined class in jdk, available in java.lang package.
		 * So Bootstrap classloader loads Thread class when we print classloader it
		 * returns null, since Bootstrap classloader is not implemented in java
		 */
		System.out.println("classloader for Thread class is : " + Thread.class.getClassLoader());
		
		// lets use join method on t1. so main thread will wait till t1 completes its execution
		try {
			t1.join();
		} catch (InterruptedException e) {
			// InterruptedException is checked exception. So we have to handle this exception
			e.printStackTrace();
		}
		
		// after completing thread execution thread state will be terminated
		System.out.println("after completing thread t1 execution, thread state will be : " + t1.getState());
		
		// t1 completed its execution, and state is TERMINATED. Now check whether it alive or not
		if (t1.isAlive()) {
			System.out.println("t1 is not alive. It is terminated.");
		} else {
			System.out.println("t1 is not alive");
		}

		// Since t1 completed its execution, main thread state will be RUNNABLE
		System.out.println("main thread state will be after t1 completion : " + main.getState());
		
	}
	
	static class ThreadImpl extends Thread {
		
		@Override
		public void run() {
			System.out.println("inside run method");
			// know the state of thread
			State state = Thread.currentThread().getState();
			System.out.println("state of thread while running will be: "+state);
			
			// while t1 is executing main thread will be in WAIT state
			System.out.println("While t1 executing, the state of main thread will be " + main.getState());
			
			System.out.println("ThreadGroup for ThreadImpl thread is : "+Thread.currentThread().getThreadGroup());
		}
	}

}

