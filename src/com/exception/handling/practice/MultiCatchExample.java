package com.exception.handling.practice;

public class MultiCatchExample {
	public static void main(String[] args) {

		/*
		 * java 1.7 introduced multi catch. Multi catch block is used whenever exception
		 * handling code is same for multiple exceptions. In that case instead of
		 * writing same code in each catch block we can have only one multi catch block
		 */
		try {
			int[] arr = new int[5];
			// This below line causes ArrayIndexOutOfBoundsException
			System.out.println(arr[6]);
			// after above line compiler will not execute below lines
			Object obj = null;
			System.out.println(obj.toString());
		} catch(ArrayIndexOutOfBoundsException | NullPointerException exception) {
			/*
			 * There should not be any relation between exceptions specified in Multi catch
			 * block. If there is any relation we get compilation error saying exception is
			 * already caught by alternative exception
			 */
			System.out.println("Exception thrown");
		}
		
		
		// Example of multiple catch statements
		/*
		 * whenever we specify multiple catch statements one after the other, the catch
		 * block with subclass exception should come first and then parent class
		 * exception
		 */
		try {
			String word = null;
			System.out.println(word.length());
		} catch (NullPointerException ne) {
			System.out.println("Null pointer exception thrown");
		} catch (Exception e) {
			System.out.println("Exception thrown");
		}

		/*
		 * Here NullPointerException is child class, and Exception is parent for all
		 * exceptions if we reverse the order we get compilation error saying
		 * Unreachable Catch block
		 */
	}
}
