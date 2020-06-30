package com.exception.handling.practice;

public class FinallyWithReturnExample {

	public static void main(String[] args) {
		
		// when we have return statement in catch block and finally block
		String stmt = test();
		System.out.println(stmt);
	}
	
	public static String test() {
		// finally block takes priority so return statement in finally block is executed
		try {
			System.out.println("try");
			throw new Exception();
		} catch (Exception e) {
			System.out.println("catch");
			return "return";
		} finally {
			System.out.println("finally");
			return "return from finally";
		}
	}
}
