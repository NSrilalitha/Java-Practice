package com.exception.handling.practice;

public class NestedTryCatchExample {

	public static void main(String[] args) {
		
		try {
			System.out.println("nested try catch example");
			try {
				// Divide by 0 causes Arithmetic exception
				int b = 20 / 0;
			} catch (ArithmeticException e) {
				System.out.println("arithmetic exception : " + e.getMessage());
			}
			String str = null;
			// if we perform any operation on null, it throws NullPointerException
			System.out.println(str.length());
			// if we write anything after the line which causes exception, that line will not
			// gets executed
			System.out.println("this line will not get executed");
		} catch (Exception e) {
			System.out.println("exception : " + e.getMessage());
		}
		System.out.println("hello");
	}
}
