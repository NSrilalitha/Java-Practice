package com.exception.handling.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.serialization.concept.practice.Person;

/**
 * This class explains try-with-resources statement with examples
 * 
 * @author Srilalitha
 *
 */
public class TryWithResourcesExample {

	public static void main(String[] args) {
		
		// java 1.7 introduced try-with-resources statement
		/*
		 * when we use try-with-resources resources will be automatically closed after
		 * try block execution. catch and finally blocks are not mandatory if we use
		 * try-with-resources
		 */
		System.out.println("============Example-1=================");
		try (Scanner scan = new Scanner(System.in);) {
			// the resources should be of java.lang.AutoCloseable or java.io.Closeable
			// the resources given in try-with-resources are by default final. If we try to reassign we
			// get compile time error
			
			// read string
			System.out.println("Read string");
			String str = scan.next();
			System.out.println(str);
			
			// try to reassign scan since it is final it gives compilation error
			// scan = new Scanner("lalitha is a good girl");	
		}
		
		System.out.println("=================Example-2================");
		// we can specify multiple resources in try-with-resources
		try (FileInputStream fis = new FileInputStream("C:\\Srilalitha\\person.txt");
				Scanner scan = new Scanner("10 lalitha 20 Srilalitha 30 Nittala");) {

			// Now reading data from file using ObjectInputStream for deserializing object 
			System.out.println("======== reading data from file using InputStream========");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				Person person = (Person) ois.readObject();
				System.out.println("Person object : "+person.toString());
			} catch (ClassNotFoundException e1) {
				System.out.println("Exception occured while deserializing object using ObjectInputStream");
			} finally {
				ois.close();
			}
			
			// separate integers and strings from given input string
			List<Integer> intList = new ArrayList<>();
			List<String> strList = new ArrayList<>();
			
			// Scanner parses the input
			while (scan.hasNext()) {
				String str = scan.next();
				// check string is number or not. If number add it to intList or else strList
				try {
					// if not able convert string to int parseInt method throws NumberFormatException
					int num = Integer.parseInt(str);
					intList.add(num);
				} catch (NumberFormatException e) {
					// if not able to convert it comes here. then add that string to strList
					strList.add(str);
				}
			}
			
			// Now print both lists
			System.out.println("Integer list....");
			System.out.println(intList.toString());
			
			System.out.println("String list....");
			System.out.println(strList.toString());	
			
		} catch (FileNotFoundException e2) {
			System.out.println("File not found");
		} catch (IOException e2) {
			System.out.println("IO exception thrown");
		} 
		
		System.out.println("==========Example-3============");
		// if u are not using try-with-resources, if u are using normal try, 
		// then catch or finally block are mandatory
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception thrown");
		}
	}
}
