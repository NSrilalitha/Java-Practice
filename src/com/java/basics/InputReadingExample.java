package com.java.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputReadingExample {

	public static void main(String[] args) {
		
		/**
		 * BufferedReader reads input in only string format using readLine method
		 * Inorder to get specific type we have to user parse methods of Wrapper
		 * classes.
		 * Size of BufferedReader is 8KB
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int a = Integer.parseInt(reader.readLine());
			String word = reader.readLine();
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
		 * different types of input like int, byte, shor, float, double, string etc. Due
		 * to parsing Scanner is bit slow than BufferedReader
		 * 
		 * Size of Scanner is 1KB. If input is larger, then its better to use
		 * BufferedReader since BufferedReader capacity is high.
		 */
		System.out.println("================Using scanner==========");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		double d = sc.nextDouble();
		sc.nextLine();
		String s1 = sc.nextLine();
		
		System.out.println(num);
		System.out.println(d);
		System.out.println(str);
		System.out.println(s1);
		
		sc.close();
	}
}
