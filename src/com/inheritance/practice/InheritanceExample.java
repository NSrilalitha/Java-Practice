package com.inheritance.practice;

public class InheritanceExample {

	public static void main(String[] args) {
		
		/*
		 * When we extend a class, sub class gets behavior and fields information from
		 * parent class. But constructors can't be inherited since constructors used to
		 * create instance. But we can call super class constructor from sub class using
		 * super keyword
		 * 
		 * But super keyword should be the first statement. If we don't specify any
		 * super keyword to call parent class constructor then in the backend JVM adds
		 * one super keyword to call default constructor of parent class. Lets verify
		 * both of these scenarios.
		 */
		
		// creating child class instance
		Child child = new Child("lalitha");
		
		// creating another child class instance with default constructor
		Child child1 = new Child();

		// If we assign Parent class object to Child class reference, We get ClassCastException
		Child ch = (Child) new Parent();
		System.out.println(ch.name);
	}
}

// Super class
class Parent {

	// instance variable
	String name;

	/*
	 * Lets comment default constructor of Parent class and verify in sub class
	 * constructor jvm class which constructor of parent class automatically
	 */
	
	// default constructor
	Parent() {
		System.out.println("in default constructor of parent class");
	} 

	// parameterized constructor
	Parent(String name) {
		this.name = name;
		System.out.println("In parameterized constructor of parent class");
		System.out.println("Parent class name value : " + this.name);
	}
}

// sub class
class Child extends Parent {
	
	// instance variable
	String name;
	
	// Parameterized constructor
	Child (String name) {
		// calling parent class parameterized constructor using super keyword
		super("Srilalitha");
		this.name = name;
		System.out.println("In parameterized constructor of child class");
		System.out.println("Child class name value : " + this.name);
	}
	
	/*
	 * Note: If a class doesn't contain any constructor, then JVM creates one
	 * default constructor for that class. But if the class is having even one
	 * constructor also jvm will not create default constructor for that class
	 */
	
	/*
	 * Note: If a superclass does not have a default constructor, any subclasses
	 * extending it must make an explicit call to one of the superclass'
	 * parameterized constructors.
	 */
	
	// default constructor
	Child() {
		// not calling any super class constructor. So jvm automatically adds line with super keyword
		// in the background to call parent class default constructor
		System.out.println("In default constructor of Child class");
	} 
	
	
	
}
