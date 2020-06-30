package com.exception.handling.practice;

public class ErrorExample {

	public static void main(String[] args) {

		// we can throw any class which is Throwable type
		// Since Error and Exception both are child classes of Throwable we can throw
		// Error and Exception and its subclasses.
		try {
			System.out.println("Throwing Error");
			throw new Error("error");
		} catch (Error error) {
			/*
			 * we can catch any Throwable type But Errors are related to system hardware or
			 * some critical problems one can't fix the issue within the program, we should
			 * not try to catch. We can catch, compiler will not give compilation error but
			 * there is no use of catching it.
			 */
			System.out.println("caught error");
		}

		/*
		 * Examples of Error: StackOverflowError, OutOfMemoryError,
		 * ExceptionInInitializationError, NoClassDefFoundError etc
		 */
		System.out.println("after error");
	}
}
