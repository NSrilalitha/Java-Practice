package com.inheritance.practice;

/**
 * Method overloading is applicable to same classes as well as parent-child relationship.
 * 
 * @author Srilalitha
 *
 */
public class OverloadingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample2 s2 = new Sample2();
		s2.methodOne("lalitha");
		s2.methodOne("lalitha", "nittala");
		s2.methodOne(1);
		
		Sample1 s1 = new Sample2();
		s1.methodOne("sri");
		// reference type determines which overloaded version is selected. happens at compile time
		// since s1 is Sample1 reference variable it wont be able to detect non-overloaded method present in Sample2
		// s1.display(); // here with s1 we wont be able to find display() method.


	}	

}

class Sample1 {
	
	public void methodOne(String name) {
		System.out.println("hello "+name);
	}
	
	public void methodOne(String fn, String ln) {
		System.out.println("hello "+fn+" "+ln);
	}
	
}

class Sample2 extends Sample1 {
	
	public void methodOne(int num) {
		System.out.println("Given number is "+num);
	}

	public void display() {
		System.out.println("I am in display method");
	}
}
