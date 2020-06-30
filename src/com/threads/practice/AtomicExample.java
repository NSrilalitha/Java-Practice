package com.threads.practice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {

	public static void main(String[] args) {
		
		// Create object for AtomicCounter class
		AtomicCounter obj = new AtomicCounter();
		obj.increment();
		// print counter value
		System.out.println("The counter value after increment : "+obj.getCounter());
		// now decrement count
		obj.decrement();
		// print counter value
		System.out.println("The counter value after decrement : "+obj.getCounter());
		// after decrement counter became 0. Now compare counter with 0, if it is 0 update it as 2
		obj.compare();
		// print counter value
		System.out.println("The counter value after comparison : "+obj.getCounter());
	}

}

class AtomicCounter {
	
	private AtomicInteger counter = new AtomicInteger(0);
	
	public void increment() {	
		counter.getAndAdd(1);
		// or to increment by just 1 we can use below method as well.
		//counter.incrementAndGet();	
	}
	
	public void decrement() {
		// to decrement the value by 1 i.e., counter-1
		//counter.getAndDecrement();
		// or to decrement we can user below method as well
		counter.decrementAndGet();
	}
	
	public void compare() {
		
		// compare counter value with 0, if it is 0 update it with 2
		counter.compareAndSet(0, 2);
	}
	
	public int getCounter() {
		return counter.intValue();
	}
}
