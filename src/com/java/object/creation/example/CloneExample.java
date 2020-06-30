package com.java.object.creation.example;

public class CloneExample {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		Student obj1 = new Student();
		Name name1 = new Name();
		name1.setFirstName("sri");
		name1.setLastName("Nittala");
		
		Address address1 = new Address();
		address1.setStreet("1st main");
		address1.setCity("Bangalore");
		address1.setState("Karnataka");
		
		obj1.setName(name1);
		obj1.setAddress(address1);
		
		System.out.println(obj1.toString());
		
		// Now clone Student object
		Student obj2 = (Student) obj1.clone();
		System.out.println(obj2.toString());
		
		// Now try to modify name of obj2
		Name name2 = new Name();
		name2.setFirstName("sri");
		name2.setLastName("jayanthi");
		obj2.setName(name2);
		
		name1.setFirstName("srilalitha");
		name1.setLastName("jayanthi");
		obj1.setName(name1);
		
		System.out.println("********Demo on shallow cloning********");
		// now print obj2 and obj1 both and verify in both places name different or not
		System.out.println(obj2.toString());
		System.out.println(obj1.toString());
	}
}
