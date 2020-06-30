package com.java.collection.framework.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

/**
 * This program explains HashMap, TreeMap, LinkedHashMap and Hashtable 
 * Explains operations like adding elements, null insertion, synchronization, 
 * making immutable, printing and sorting.
 * 
 * @author Srilalitha
 *
 */
public class MapExample {

	public static void main(String[] args) {
		
		// HashMap doesn't allow duplicate keys. If we add same key again, the previous key's value get override with
		// new value.
		// HashMap allows one null key 
		System.out.println("======================= HashMap ==================");
		HashMap<String, String> empMap = new HashMap<>();
		
		empMap.putIfAbsent("26", "testt");
		empMap.put("12", "test");
		empMap.put("5", "tre");
		empMap.put("32", "ram");
		empMap.put("90", "suta");
		empMap.put("1", "kivi");
		empMap.put("5", "tree");
		empMap.put(null, "radha");
		empMap.put(null, null);
		
		// print map
		System.out.println("========= printing map ============");
		Set<Entry<String, String>> empSet = empMap.entrySet();
		for(Entry<String, String> entry: empSet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println("Map size " + empMap.size());
		
		System.out.println("===================================");
		System.out.println("HashMap is non-synchronized i.e., it is not thread safe");
		// To get synchronized Map we can use synchronizedHashMap method in Collections util class
		Map<String, String> syncMap = Collections.synchronizedMap(empMap);
		// syncMap is synchronized now
		syncMap.put("90", "suda");
		syncMap.put("23", "after");
		
		Set<Entry<String, String>> syncSet = syncMap.entrySet();
		for(Entry<String, String> entry: syncSet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println("===================================");
		System.out.println("HashMap is mutable. To get immutable i.e., unchanged Map use unmodifiedMap method of Collections");
		Map<String, String> unModifiedMap = Collections.unmodifiableMap(empMap);
		// Now unModifiedMap is immutable
		// Now try to modify map, we get UnsupportedOperationException
		try {
			unModifiedMap.put("90", "sudha");
		} catch(UnsupportedOperationException ex) {
			System.out.println("exception thrown");
		}
		
		Set<Entry<String, String>> unModSet = unModifiedMap.entrySet();
		for(Entry<String, String> entry: unModSet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println("===================================");
		System.out.println("Map with custom object as key");
		// Map which takes key as custom object and value is string
		Map<Student, String> studentMap = new HashMap<>();
		
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
		
		studentMap.put(s1, "A");
		studentMap.put(s2, "A");
		studentMap.put(s3, "B");
		studentMap.put(s4, "C");
		
		/*
		 * If we do any changes in the Student class or update values in the object, hashcode will change
		 * Due to this it will treat that object as new  key since hashcode will be different.
		 * so whenever we try to add any object as key then the class should be immutable. So make that class immutable.
		 *  And in class we should override equals and hashcode methods
		 */
		// print map
		Set<Entry<Student, String>> studentEntry = studentMap.entrySet();
		for(Entry<Student, String> entry: studentEntry) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		System.out.println(studentMap.get(s3));
		
		System.out.println("============ sorting HashMap based on key ===========");
		Map<Integer, String> map = new HashMap<>();
		map.put(123, "rama");
		map.put(53, "ragav");
		map.put(12, "shailendra");
		map.put(87, "laxman");
		map.put(33, "swathi");
		
		// print map
		System.out.println("=========== before sorting ===============");
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		// now sort the map based on key
		List<Entry<Integer,String>> entryList = new ArrayList<>(entrySet);
		Collections.sort(entryList, new KeyComparator());
		
		// Now get the sorted Map, since to preserve the order using LinkedHashMap
		LinkedHashMap<Integer,String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer,String> entry: entryList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		// now print sorted map
		System.out.println("===============After sorting=============");
		for (Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		System.out.println("============ sorting HashMap based on value ===========");
		Collections.sort(entryList, new ValueComparator());
		
		LinkedHashMap<Integer, String> sortedValueMap = new LinkedHashMap<>();
		for(Entry<Integer,String> entry: entryList) {
			sortedValueMap.put(entry.getKey(), entry.getValue());
		}
		
		// now print sorted map
		System.out.println("===============After sorting=============");
		for (Entry<Integer, String> entry : sortedValueMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		// For natural sorting of map based on key, we can use TreeMap as well
		TreeMap<Integer, String> treeMap = new TreeMap<>(map);
		
		// now print map
		System.out.println("====== sorting of map based on keys using TreeMap====");
		for (Entry<Integer, String> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
				
		
		// hashtable
		System.out.println("==================== Hashtable =================");
		// hashtable doesn't allow a null key or value
		Hashtable<String, String> htable = new Hashtable<>();
		htable.put("1","srilalitha");
		htable.put("2", "nittala");
		
		System.out.println("hashtable doesn't allow null key or value");
		System.out.println("if we add null key or value in Hashtable, we get NullPointerException");
		// htable.put(null, "test");
		// htable.put("3", null);
		
		htable.put("1", "lalitha");
		
		Set<Entry<String, String>> hentry = htable.entrySet();
		for(Entry<String, String> entry: hentry) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
	
}

/**
 * Comparator to sort the Map based on keys
 * 
 * @author Srilalitha
 *
 */
class KeyComparator implements Comparator<Entry<Integer, String>> {

	@Override
	public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
		if (o1.getKey() == o2.getKey()) return 0;
		else if (o1.getKey() > o2.getKey()) return 1;
		else return -1;
	}
	
}

class ValueComparator implements Comparator<Entry<Integer, String>> {

	@Override
	public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
		// sorting in descending order
		return o2.getValue().compareTo(o1.getValue());
	}
	
}
