package com.java.object.creation.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * This class demonstrates the ways to create objects in java.
 * 
 * Reference: https://www.javatpoint.com/how-many-ways-to-create-an-object-in-java
 *
 */
public class TestObjectCreation implements Cloneable {

	public static void main(String[] args) {
		
		System.out.println("********************Approach-1**********************");
		//Approach-1: using new operator
		TestObjectCreation obj1 = new TestObjectCreation();
		
		
		System.out.println("********************Approach-2**********************");
		//Approach-2: Using newInstance() method of Class class
		try {
			TestObjectCreation obj2 = TestObjectCreation.class.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.out.println("Exception occured while creating instance with newInstance() method of class");
		}
		
		
		System.out.println("********************Approach-3**********************");
		//Approach-3: Using newInstance() method of Constructor class
		// Constructor class present in java.lang.reflect package
		Constructor<TestObjectCreation> constructor = null;
		try {
			constructor = TestObjectCreation.class.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println("Exception occured while getting Constructor");
		}
		// constructor class newInstance() may throw ExceptionInInitializeError as well since
		// it is Error we should not try to catch
		try {
			TestObjectCreation obj3 = constructor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println(
					"Exception occured while trying to create instance using newInstance() method of Constructor class");
		}
		
		
		System.out.println("********************Approach-4**********************");
		try {
			TestObjectCreation obj4 = (TestObjectCreation) obj1.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("Exception occured while creating object using clone method");
		}
		
		
		System.out.println("********************Approach-5**********************");
		// using serialization and deserialization we can get java object by implementing Serializable interface
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
