package com.java.collection.framework.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This class demonstrates java 8 features like lambda expressions, method
 * references and streams
 * 
 * @author Srilalitha
 *
 */
public class Java8FeaturesExample {

	public static void main(String[] args) {
		
		int[] numbers = {10,20,1,2,3,7,0};
		
		IntStream.of(numbers).sorted().distinct().limit(3).forEach(System.out::println);
		
		System.out.println(IntStream.of(numbers).allMatch(num -> num%2==0));
		
		String[] arr = {"hackerrank.com", "hackerrank.com", "hackerearth.com", "interviewbit.com", "udemy.com", "udemy.com", "udemy.com"};
		
		List<String> wordsList = Arrays.asList(arr);
		
		System.out.println(wordsList.stream().distinct().count());
		
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		System.out.println("Print list without java 8 foreach");
		// print list till java 7
		for(String str: list) {
			System.out.println(str);
		}
		
		System.out.println("printing list using java 8 foreach along with lambda");
		list.forEach((str) -> System.out.println(str));
		
		System.out.println("printing list using java 8 foreach with method references");
		list.forEach(System.out::println);
		
		System.out.println("=========Sorting without lamdas=========");
		// sort the list using comparator without lamda
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
			
		});
		System.out.println(list.toString());
		
		System.out.println("============sorting with lamdas============");
		// sort list using comparator with lamda
		Collections.sort(list, (String s1,String s2) -> s1.compareTo(s2));
		// print list
		System.out.println(list.toString());
		
		
		// Create a map
		Map<String, String> map = new HashMap<>();
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		
		// Now print map through iterating it without using java 8 foreach
		System.out.println("==========Printing map without java 8 foreach======");
		for(Entry<String,String> entry: map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		// Print map using java 8 foreach
		System.out.println("==========Printing map with java 8 foreach======");
		map.forEach((key,value) -> System.out.println(key + " " + value));
		
		
		// Streams example
		System.out.println("==========Demo on streams=========");
		List<String> names = new ArrayList<String>();
		names.add("sri");
		names.add("lalitha");
		names.add("Santosh");
		names.add("Nittala");
		names.add("Jayanthi");
		names.add("sri");
		names.add("Santosh");
		// now we have list, now get only strings whose length is greater than 3 and then make those string to uppercase
		// and sort those strings and print 
		List<String> sortedList = names.stream().filter(str -> str.length()>3).map(String::toUpperCase).sorted().collect(Collectors.toList());
		System.out.println(sortedList.toString());
		
		System.out.println("print only distinct names");
		List<String> distinctList = names.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctList.toString());
		
		// sort the list using streams
		System.out.println("sorting the list using java streams");
		names.stream().sorted().forEach(System.out::println);
		
		// Create stream using stream.of method
		Stream<Integer> intStream = Stream.of(1,2,3,4,5);
		System.out.println("========printing intstream=======");
		intStream.forEach(System.out::println);
		
		// create stream from list
		Stream<String> namesStream = names.stream();
		System.out.println("=====printing names stream=====");
		namesStream.forEach(System.out::println);
		
		// Stream can be created using Stream.generate(Supplier s) method
		// here Supplier is a functional interface which can be expressed as lambda expression
		
		// Now I have Employee class. Lets create a list of Employess.
		List<Employee> empList = new ArrayList<>();
		Employee emp1 = new Employee();
		emp1.setName("Priya");
		emp1.setId("100");
		emp1.setSalary(10000.0);
		
		Employee emp2 = new Employee();
		emp2.setName("Alex");
		emp2.setId("102");
		emp2.setSalary(5000.0);
		
		Employee emp3 = new Employee();
		emp3.setName("Ram");
		emp3.setId("105");
		emp3.setSalary(16000.0);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);

		System.out.println("=========Sorting emp list in ascending order of salaries using streams========");
		// Now sort the employee list based on their salaries in ascending order
		empList.stream().sorted((e1, e2) -> e1.getSalary().compareTo(e2.getSalary())).forEach(System.out::println);

		// Sort the employees in descending order of their Salaries
		System.out.println("============Sorting emp list in descending order of salaries and print their names=====");
		empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getName).forEach(System.out::println);
		
		// now filter employees whose salary is greater than 5000
		System.out.println("==========Filtering emp list whose salary is greater than 5000========");
		empList.stream().filter(emp -> emp.getSalary()>5000.0).forEach(System.out::println);
	
		List<String> empNames = new ArrayList<>();
		empList.stream().map(Employee::getName).map(String::toUpperCase).forEach(empNames::add);
		System.out.println("=====emp names in uppercase=====");
		System.out.println(empNames.toString());
		
		// read lines from a file using java 8
		// find 3 lines which starts with word "ERROR"
		try {
			List<String> errorLines = 
					Files.lines(Paths.get("test-file.txt"))
						 .filter(line -> line.startsWith("ERROR"))
						 .limit(3)
						 .collect(Collectors.toList());
			System.out.println(errorLines);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                     						
		
	}
}

class Employee {
	
	private String name;
	
	private String id;
	
	private Double salary;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

	
	
	
}
