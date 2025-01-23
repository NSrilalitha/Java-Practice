package com.java.collection.framework.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Find frequency of each character in a string using Map
 * 
 * @author Srilalitha
 *
 */
public class MapJava8Features {

	public static void main(String[] args) {

		// in java8 new methods (default methods) introduced in Map interface. eg: compute(), computeIfPresent(), computeIfAbsent()
		
		String str = "lalitha";
		// now find frequency of each character in given string using map
		Map<Character, Integer> map = new HashMap<>();
		
		for (int i=0;i<str.length();i++) {
			Character ch = str.charAt(i);
			if (null == map.get(ch)) {
				// if corresponding key is not present or key is mapped to null then computeIfAbsent methods computes a value and
				// assign it to corresponding key
				map.computeIfAbsent(ch, (character) -> 1);
				// above can be altered as shown below
				//map.putIfAbsent(ch, 1);
			} else {
				// if key is already present and not null, then update its value by computing using a function which is represented in
				// lambda expression
				map.computeIfPresent(ch, (character, count) -> count+1);
			}
		}
		
		// now print map using foreach method which is introduced in java8
		// forEach is a default method in Map interface. which takes BiConsumer as input 
		map.forEach((character, count) -> System.out.println(character + " " + count));
		
		System.out.println("==============Example-2==================");
		// now create another map which holds person name and his profession. 
		Map<String, String> personMap = new HashMap<>();
		personMap.put("Sri", "Engineer");
		personMap.put("Lalitha", "Engineer");
		personMap.put("Priya", "Doctor");
		personMap.put("Sarada", "Teacher");
		personMap.put("Srinivas", "Electric Chief");
		personMap.put("Radha", "Doctor");
		// there is a new method putIfAbsent introduced in java8 in map interface
		// it adds key and corresponding value if key is not present or not associated with null
		// putIfAbsent is a default method
		personMap.putIfAbsent("Veena", "Lawyer");
		
		// Now print map using entrySet
		Set<Entry<String, String>> entrySet = personMap.entrySet();
		// we can use lambda expression with entrySet as well 
		entrySet.forEach((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));
		
		Map<String, String> personMapCopy = new HashMap<>(personMap);		
		// Now print cloned copy of person map using keySet
		System.out.println("============copy of person map=========");
		personMapCopy.keySet()
					 .forEach((person) -> System.out.println(person + " - " + personMapCopy.get(person)));
		
		// Now replace all entries corresponding to persons profession to Teacher
		// there is a default method replaceAll which takes function as input introduced in java 8
		personMapCopy.replaceAll((person, profession) -> profession = "Teacher");
		
		// print personMap
		System.out.println("============After changing profession to Teacher===========");
		personMapCopy.forEach((person, profession) -> System.out.println(person + " - " + profession)); 
		
		System.out.println("==================Example-3==============");
		// now sort the person map using value in ascending order using java 8 streams
		personMap.entrySet().stream()
							.sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
							.forEachOrdered((entry) -> System.out.println(entry.getKey() + " - " + entry.getValue()));

		// above can be altered as shown below using comparingByValue method
		System.out.println("====printing the sorted map====");
		personMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.forEachOrdered((entry) -> System.out.println(entry.getKey() + " = " + entry.getValue()));
	}

}
