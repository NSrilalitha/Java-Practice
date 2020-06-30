package com.threads.practice;

public class NullArgumentExample {

	public static void main(String[] args) {
		
		
		// Thread constructors
		/*
		 * below line gives compilation error saying ambiguous because there are two
		 * thread constructors for one Runnable object passed as argument and for
		 * another constructors String passed as argument. If we pass null there will be
		 * ambiguity.
		 */
		//Thread t = new Thread(null);
		
		RunnableImpl obj = null;
		// here there will not be ambiguity since we are passing Runnable implementation class object.
		// but object referring to null. So it considers nothing will be performed by run method. 
		Thread t = new Thread(obj);
		t.start();
		
		RunnableImpl obj1 = new RunnableImpl();
		Thread t1 = new Thread(obj1, "Thread1");
		t1.start();
		// print name of thread t1
		System.out.println("name of thread t1 : "+t1.getName());
		
		
		// if we dont specify name of thread, JVM automatically creates name in "Thread-n" format. 
		// lets give null for thread name and verify what happens
		// It throws NullPointerException. Name can't be null.
		try {
			Thread t2 = new Thread(obj1, null);
			t2.start();
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception thrown since name is null");
		}
		
		
	}
}

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("in run method");
	}
		
}
