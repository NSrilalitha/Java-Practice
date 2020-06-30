package com.test.integer.type.practice;

/*
 * This class demonstrates conversion of higher type to lower type.
 */
public class TypeConversion {
	
	public static void main(String[] args) {
		double a = 295.04;
		int b = 300;
		// conversion of double to byte
		byte c = (byte) a;
		// conversion of int to byte
		byte d = (byte) b;
		System.out.println(c + " " + d);
	}
	
}
