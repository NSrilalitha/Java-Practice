/**
 * 
 */
package com.string.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. Find frequency of a word in a list
 * 2. Make ArrayList immutable
 * 
 * @author Srilalitha
 *
 */
public class FindFrequency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final List<String> list = new ArrayList<>();
		list.add("ravi");
		list.add("tej");
		list.add("ravi");
		list.add("tej");
		list.add("ravi");
		System.out.println(list.toString());
		
		// find frequency
		int frequency = Collections.frequency(list, "tej");
		System.out.println("tej's freq is "+frequency);
		
		// ArrayList is mutable. 
		// Make ArrayList immutable.
		List<String> unlist = Collections.unmodifiableList(list);
		System.out.println("unmodified list is "+unlist.toString());
		
		// now try to change the list. We get UnsupportedOperationException
		try {
			unlist.add("tej");
			int freq = Collections.frequency(unlist, "tej");
			System.out.println("tej's freq is "+freq);
		} catch(Exception e) {
			System.out.println("cant modify unmodified list");
		}
		
	}

}
