/**
 * 
 */
package com.serialization.concept.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * This class illustrates Serialization and deserialization
 * 
 * @author Srilalitha
 *
 */
public class PersonSerializer {
	
	public static void main(String[] args) {
		
		// person object which is to be serialized and deserialized
		Person person = new Person();
		person.setId(111);
		person.setName("Raj");
		person.setHeight("6.1");
		person.setSalary("50000");

		try {
			// Serializing object. Serialization means converting java object to byte stream
			// to transfer over network or save it to file.
			// saving java object to file.
			File file = new File("C:\\Srilalitha\\person.txt");
			FileOutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			System.out.println("before serialization person object is " + person.toString());
			oos.writeObject(person);
			oos.close();

			// deserializing
			FileInputStream inputStream = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			Person dePerson = (Person) ois.readObject();
			System.out.println("deserialized person object is " + dePerson.toString());
			ois.close();
			
			// check serialVersionUID is same in both serialized and deserialized objects
			System.out.println("**************************************************");
			if (person.getSerialversionuid() == dePerson.getSerialversionuid()) {
				System.out.println("same serial version uid");
			}
			
			// Note: Static fields and transient variables can't be serialized. To make it serializable we have to write custom serializers.
			System.out.println("**************************************************");
			System.out.println("static variable of person object is "+person.getSalary());
			System.out.println("transient variable of person object is "+person.getHeight());
			System.out.println("==========================================================");
			System.out.println("static variable of person object deserialized is "+dePerson.getSalary());
			System.out.println("transient variable of person object deserialized is "+dePerson.getHeight());
			System.out.println("**************************************************");
		
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
