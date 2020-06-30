package com.java.basics;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * This class demonstrates Class class and its methods and about class loaders.
 * 
 * @author Srilalitha Nittala
 *
 */
public class ClassLoaderExample {

	public static void main(String[] args) {

		String str = new String("hello");
		// String is an object.
		// String is predefined class in java which is available in rt.jar which can be
		// loaded by bootstrap class loader
		Class<String> cl = (Class<String>) str.getClass();
		ClassLoader classLoader = cl.getClassLoader();
		// Since BootstrapClassLoader is not in java, we get null
		System.out.println(classLoader);

		// to know constructors present in String class we can using Class methods
		Constructor<?>[] constructors = cl.getConstructors();
		System.out.println("Constructors avaiable in String class are " + Arrays.toString(constructors));
		System.out.println("Total Constructors avaiable in String class : " + constructors.length);

		// to know methods present in String class we can use below Class method
		Method[] methods = cl.getDeclaredMethods();
		System.out.println("Methods available in String class");
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}

		Animal animal = new Animal();
		// To know classLoader information of Animal class get Class of Animal class.
		// since animal class is custom class, the .class file of this class available
		// in classpath, so it will be loaded by ApplicationClassLoader
		Class<Animal> animalClass = (Class<Animal>) animal.getClass();
		System.out.println(animalClass.getClassLoader());
	}
}

class Animal {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

}
