package com.java.design.patterns.practice;

public class SingletonExample {

	public static void main(String[] args) {
		
		// using getInstance() static method to retrieve instance of MySingleton class
		MySingleton mySingleton = MySingleton.getInstance();
		mySingleton.testMethod();
	}
}

// making MySingleton class as Singleton
// Singleton means per jvm there should be only one instance for that class
class MySingleton {
	
	// create private static MySingleton class variable
	private static MySingleton instance;
	
	// Object should be created only once. So I am instantiating this class
	// using static block since static block executed only once
	static {
		instance = new MySingleton();
	}
	
	// make constructor as private so outside we can't instantiate this class
	private MySingleton() {
		System.out.println("in singleton class constructor");
	}
	
	// to use instance outside create public method to return instance of this class
	public static MySingleton getInstance() {
		return instance;
	}
	
	public void testMethod() {
		System.out.println("Created instance for singleton class");
	}
}
