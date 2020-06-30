/**
 * 
 */
package com.serialization.concept.practice;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * This class needs to be serialized. So implement Serializable marker interface.
 * 
 * @author Srilalitha
 *
 */
public class Person implements Serializable {

	/**
	 * SerialVersionUID used to check deserialized object is same as of serialized object.
	 */
	private static final long serialVersionUID = -2201169215423400133L;

	private int id;
	
	private String name;
	
	static String salary = "30000";
	
	transient String height;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getSalary() {
		return salary;
	}

	public static void setSalary(String salary) {
		Person.salary = salary;
	}

	

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", height=" + height + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// Performing customized serialization using the below two methods: 
    // this method is executed by jvm when writeObject() on 
    // Person object reference in main method is 
    // executed by jvm. 
	private void writeObject(ObjectOutputStream oos) throws Exception {
		// to perform default serialization
		oos.defaultWriteObject();
		// sending transient variable 
		this.height = "10.11";
		oos.writeObject(this.height);
	}
	
	private void readObject(ObjectInputStream ois) throws Exception {
		// to perform default deserialization
		ois.defaultReadObject();
		String hheight = (String) ois.readObject();
		System.out.println("deserialized height variable is "+hheight);
		
	}
	
}
