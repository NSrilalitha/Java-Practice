package com.exception.handling.practice;

public class FinallyExample {

	public static void main(String[] args) {
		
		// If we dont come inside try block then finally block assiciated with try block
		// will not get executed
		
		try {
			
			// lets write some code which causes exception
			String word = null;
			// below line causes NullPointerException so after this execution of further
			// steps will be stopped and outer catch block gets executed
			System.out.println(word.length());
			
			// here create try catch finally
			// since above exception compiler will not execute this try block
			// since control will not come to this try block finally block will not
			// gets executed
			try {
				// this below line causes arithmetic exception
				int num = 20/0;
				System.out.println(num);
			} catch (ArithmeticException e) {
				System.out.println("Exception : " + e.getMessage());
			} finally {
				System.out.println("in finally block");
			}
			
		} catch (Exception e) {
			System.out.println("Null pointer exception thrown");
		} finally {
			System.out.println("in outer finally block");
		}
		
	}
}
