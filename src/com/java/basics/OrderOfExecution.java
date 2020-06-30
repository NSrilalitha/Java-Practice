package com.java.basics;

/**
 * This class explains order of static block, instance block, constructor and
 * main method.
 * 
 * @author Srilalitha
 *
 */
public class OrderOfExecution {

	public static void main(String[] args) {
		
		/*
		 * Order of execution: 1. Static block 2. main method 3. incase of inheritance
		 * first parent class static blocks, and then child class static blocks 3. based
		 * object creation, corresponding clss instance block gets called followed by
		 * its constructor 4. static block gets executed only once by JVM whenever it
		 * loads the class using Class loader subsystem. 5. Instance block gets executed
		 * whenever we create object using constructor. 6. We can have multiple static
		 * blocks and multiple instance blocks. Their order of execution is from top to
		 * bottom.
		 */
		System.out.println("in main method");
		
		B bobj = new B();
		
		OrderOfExecution mainObj = new OrderOfExecution();
	}
	
	static {
		System.out.println("in static block of main class");
	}
	
	{
		System.out.println("in initialization block of main class");
	}
	
}

class A {
	
	static {
		System.out.println("in static block of A class");
	}
	
	{
		System.out.println("in initialization block of class A");
	}
	
	A() {
		System.out.println("in Constructor of A class");
	}
}

class B extends A {
	
	static {
		System.out.println("in static block of B class");
	}
	
	{
		System.out.println("in initialization block of B class");
	}
	
	B() {
		System.out.println("in constructor of B class");
	}
}

