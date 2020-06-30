package com.inheritance.practice;

/**
 * Method Overriding example
 * 
 * @author Srilalitha
 *
 */
public class OverridingExample {
	
	public static void main(String[] args) {
		// This is acceptable. Runtime polymorphism
		Super obj = new Sub();
		// overridden method gets called
		obj.print();
		
		// This is not acceptable. Below line causes ClassCastException since We can't
		// reference Super class object with child class reference variable.
		// Sub y = (Sub) new Super();
	}
}

class Super {
	
	public void print() {
		System.out.println("in Super class");
	}
}

class Sub extends Super {
	
	// since we are giving same name and same signature it is method overriding
	@Override
	public void print() {
		// super can be used to call parent class method
		// calling parent class print method
		super.print();
		// this is logic of child class
		System.out.println("in sub class");
	}
}
