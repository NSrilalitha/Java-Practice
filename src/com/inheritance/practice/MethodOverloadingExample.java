package com.inheritance.practice;

public class MethodOverloadingExample {

	public static void main(String[] args) {
		
		A a = new A();
		a.print();
		a.print("lalitha");
		a.display(10);
		a.display(10.0F);
		// passing short value as argument
		a.display((short)10);
		// passing float value as argument
		float num = a.display(11.0F);
		System.out.println("float number returned is "+num);
		a.show();
		a.show("lalitha");
		A.show("srilalitha");
	}

}

class A {
	
	public void print() {
		System.out.println("hello");
	}
	
	void print(String name) {
		System.out.println("hello..."+name);
	}
	
	public void display(int num) {
		System.out.println("int argument");
	}
	
	public float display(float num) {
		return 11.0F;
	}
	
	public void display(short num) {
		System.out.println("short argument");
	}
		
	void show() {
		System.out.println("show method");
	}
	
	// by just changing only modifier we can't achieve overloading. Suppose here if
	// i remove
	// name argument compiler says duplicate methods since the only difference is
	// modifier
	static void show(String name) {
		System.out.println("static show method");
	}

	// Note: For overloading we can change modifiers as well
	
	// Commenting below code since compiler says duplicate methods since the method
	// names and arguments are same. We can't achieve method overloading just by
	// throws clause variation.
	
	/*
	 * public void printData(String i) throws Exception {
	 * System.out.println("first"); }
	 * 
	 * public void printData(String data) {
	 * 
	 * }
	 */
}


