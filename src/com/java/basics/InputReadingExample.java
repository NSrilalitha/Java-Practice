package com.java.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReadingExample {

	public static void main(String[] args) {

		/**
		 * BufferedReader reads input in only string format using readLine method
		 * Inorder to get specific type we have to use parse methods of Wrapper classes.
		 * Size of BufferedReader is 8KB
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter number");
			int a = Integer.parseInt(reader.readLine());
			System.out.println("Enter String");
			String word = reader.readLine();
			System.out.println("Enter double value");
			double b = Double.parseDouble(reader.readLine());

			System.out.println(a);
			System.out.println(b);
			System.out.println(word);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// using scanner to read input from user
		/*
		 * Scanner does parsing as well. Scanner provides various methods to read
		 * different types of input like int, byte, short, float, double, string etc.
		 * Due to parsing Scanner is bit slower than BufferedReader
		 * 
		 * Size of Scanner is 1KB. If input is larger, then its better to use
		 * BufferedReader since BufferedReader capacity is high.
		 */
		System.out.println("================Using scanner==========");
		Scanner sc = new Scanner(System.in);
		// if we are reading multiple integers or any datatype other than String then
		// call nextLine() method after reading all those
		System.out.print("Enter number: ");
		int num = sc.nextInt();
		//reading another number
		System.out.print("Enter another number: ");
		double num1 = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter string: ");
		String str = sc.nextLine();
		System.out.print("Enter double value: ");
		double d = sc.nextDouble();
		sc.nextLine();
		System.out.print("Enter string: ");
		String s1 = sc.nextLine();

		System.out.println("entered values are as follows");
		System.out.println(num);
		System.out.println(num1);
		System.out.println(d);
		System.out.println(str);
		System.out.println(s1);

		sc.close();
	}
}
