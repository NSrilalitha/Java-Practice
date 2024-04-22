package com.string.practice;

/**
 * This program is to illustrate how string comparison happens
 * 
 * @author Srilalitha
 */
public class StringComparison {
	
	public static void main(String[] args) {
		
		// whenever we create String object using string literal, the object creates in "String constant pool" in heap memory
		// if same object already exists in String constant pool, then new object will not be created
		String s1 = "Hi";
		String s2 = "Hi"; // Here Hi is already created in pool. So s2 points to the same object in pool
		
		String s3 = new String("Hi"); // each time new object will be created if we create object with new operator.
		String s4 = new String("Hi"); // here objects are creating in non-pool area in heap memory.  Thats why s3 an s4 references will not be pointing to same object
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s4);
	}

}
