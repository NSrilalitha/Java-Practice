package com.java.collection.framework.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionExample {

	@SuppressWarnings("rawtypes")
	public static void main(String... args) {

		System.out.println("********************ArrayList************************");
		// ArrayList
		// ArrayList preserves the insertion orders. Null can be inserted
		// if list has Null and if we perform any operation like sort, it throws
		// NullPointerException
		List<String> names = new ArrayList<String>();
		names.add("first");
		names.add("abc");
		names.add("zye");
		names.add("tej");
		// names.add(null);

		System.out.println(names);
		System.out.println(names.size());

		// sort in ascending order
		System.out.println("==========sort list using Collections.sort method ==========");
		Collections.sort(names);
		System.out.println(names);

		// sort in descending order using Collections.reverserOder()
		System.out.println("===========reverse using built in method============");
		Collections.reverse(names);
		System.out.println(names);

		System.out.println("==========sort list in reverse order using built in method===========");
		Collections.sort(names, Collections.reverseOrder());
		System.out.println(names);

		System.out.println("===========sort list in reverse oder using comparator=============");
		Collections.sort(names, new NameComparator());
		System.out.println(names);

		System.out.println("*********************Set******************");
		// set
		// HashSet will not preserve the order
		Set<String> set = new HashSet<>();
		set.add("name");
		set.add("first");
		set.add("feb");
		set.add("march");
		set.add("null");
		// set.add(null);

		System.out.println(set);
		System.out.println(set.size());

		// sort set using Collections.sort() method by converting set to list
		// Collections.sort(new ArrayList<>(set));

		System.out.println("**********************TreeSet**********************");
		// TreeSet sorts the set in natural order
		Set<String> treeSet = new TreeSet<>();
		treeSet.addAll(set);
		// print the TreeSet which is in natural sorting order
		System.out.println(treeSet);
		// now print in descending order
		System.out.println("=========sorting in descending order using descendingSet method===========");
		// TreeSet class has descendingSet method which prints the elements in reverse
		// order
		TreeSet<String> dset = new TreeSet<>(treeSet);
		System.out.println(dset.descendingSet());

		System.out.println("==============sorting in descending order using comparator with TreeSet========");
		Set<String> tset = new TreeSet<>((String s1, String s2) -> s2.compareTo(s1));
		tset.add("sept");
		tset.add("feb");
		tset.add("jan");
		tset.add("mar");
		System.out.println(tset);

		System.out.println("=======================Number sorting===============");
		// list with numbers, sort it in descending order using
		// Collections.reverseOrder()
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(70);
		numbers.add(20);
		numbers.add(45);
		numbers.add(92);
		numbers.add(57);

		// sort the numbers in ascending order
		Collections.sort(numbers);
		System.out.println(numbers);

		// Collections.reverse(numbers);
		// System.out.println(numbers);

		// sort the numbers in descending order
		Collections.sort(numbers, Collections.reverseOrder());
		System.out.println(numbers);

		System.out.println("******************Custom object sorting*********");
		// Instantiate Student class
		Student s1 = new Student();
		s1.setId(101);
		s1.setName("tej");

		Student s2 = new Student();
		s2.setId(105);
		s2.setName("ravi");

		Student s3 = new Student();
		s3.setId(102);
		s3.setName("singh");

		Student s4 = new Student();
		s4.setId(107);
		s4.setName("ranjan");

		// create a list which holds all Student objects
		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);

		// sort the students list in ascending order based on id
		System.out.println("=========sorting in ascending order based on id==============");
		Collections.sort(students, new StudentComparator());
		// print the list using java 8
		students.forEach((student) -> System.out.println(student));

		// Sort the students list in descending order based on id
		System.out.println("=========sorting in descending order based on id==============");
		// sort using lambda expressions. The code here is equivalent to IdComparator
		students.sort((Student o1, Student o2) -> o2.getId() - o1.getId());
		students.forEach((student) -> System.out.println(student));

		// sort the students list in descending order based on their names
		System.out.println("=========sorting in descending order based on name==============");
		Collections.sort(students, new StudentNameComparator());
		students.forEach((student) -> System.out.println(student));

		// collection can hold heterogeneous elements
		ArrayList randomList = new ArrayList();
		randomList.add("lalitha");
		randomList.add(1);
		System.out.println(randomList);

		System.out.println("============Demo on unmodifiable list========");
		// Creating a list of Student
		List<Student> studentsList = new ArrayList<>();
		// add two objects
		Student obj1 = new Student();
		obj1.setId(101);
		obj1.setName("Alex");

		Student obj2 = new Student();
		obj2.setId(105);
		obj2.setName("Ram");

		studentsList.add(obj1);
		studentsList.add(obj2);

		System.out.println("------printing students list------------");
		System.out.println(studentsList);

		// Now make Students list immutable
		// By using Collections.unmodifiableList() method we can make immutable list.
		// i.e., we can't add new element or we can't remove an existing element from the
		// list
		List<Student> unModifiedList = Collections.unmodifiableList(studentsList);

		System.out.println("------printing unmodifiable students list------------");
		System.out.println(unModifiedList);

		// if we try to modify the unModifiedList, we get UnsupportedOperationException
		try {
			System.out.println("trying to remove element from unmodifiable list");
			unModifiedList.remove(obj2);
		} catch (UnsupportedOperationException e) {
			System.out.println("Exception raised while trying to modify immutable list ");
		}

		System.out.println("------we can't achieve 100% immutablity here---------");
		// Here we can't add or delete an element from unmodifiable list.
		// But we can't achieve 100% immutablity here. Since we can modify content of
		// existing
		// element inside the list. Lets try to change the content of obj2 in
		// unModifiedList

		try {
			System.out.println("----------trying to update existing student object in unmodifiable lsit-----------");
			// retrieving obj2 from unModifiedList and updating student id
			unModifiedList.get(1).setId(103);

		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot change the content of element in immutable list " + e.getMessage());
		}
		System.out.println(
				"-----Able to update existing element in unmodifiable list----100% immutablity is not achieved");
		System.out.println(unModifiedList);
	}
}

/*
 * Comparator to sort list in descending order
 */
class NameComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {

		return o2.compareTo(o1);
	}

}

/*
 * Comparator to sort Student list in ascending order based on id
 */
class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// sort it ascending order based on id
		// since id is primitive here we can't use compareTo method to compare ids here
		return o1.getId() - o2.getId();
	}

}

/*
 * Comparator to sort Student list in descending order based on id
 */
class IdComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// sort it in descending order based on id
		return o2.getId() - o1.getId();
	}

}

/*
 * Comparator to sort Student list in descending order based on name
 */
class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// sort list in descending order based on name
		return o2.getName().compareTo(o1.getName());
	}

}
