package com.java.collection.framework.practice;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapExample {

	public static void main(String[] args) {
		

		String s1 = new String("lalitha"); // it creates two objects -> 1 in non string pool, 1 in string pool
		String s2 = s1.intern();
		
		System.out.println(s1);
		System.out.println(s2);
		
		// print hashcode of s1 and s2
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
		// s1, s2 are refering two different objects. they are not equal. But their contents are equal
		if (s1 == s2) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		if (s1.equals(s2)) {
			System.out.println("content is same");
		}
		
		// now put these two strings in HashMap, 
		// since HashMap performs equal method on key it thinks it is same object and it replaces its value
		Map<String, String> map = new HashMap<String, String>();
		map.put(s1, "s1 value");
	
		System.out.println(map);
		
		// now add s2 to map and see what happens
		map.put(s2, "s2 value");
		System.out.println("================Map==========");
		System.out.println(map);
		
		// To overcome this problem we use IdentityHashMap
		
		IdentityHashMap<String, String> identityMap = new IdentityHashMap<>();
		identityMap.put(s1, "s1 value");
		identityMap.put(s2, "s2 value");
		
		System.out.println("=============IdentityHashMap===============");
		System.out.println(identityMap);
		
	}
}
