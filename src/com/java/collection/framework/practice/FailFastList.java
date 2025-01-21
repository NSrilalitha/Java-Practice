package com.java.collection.framework.practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This class demonstrate the usage of CopyOnWriteArrayList class
 */
public class FailFastList {

	public static void main(String[] args) {
	
		// case-1: Using ArrayList we try to iterate the list and update the list while iterating in the middle
		// ArrayList is fail fast iterator
		//List<String> list = new ArrayList<String>();
		
		// case-2: Using fail-safe iterator i.e., use CopyOnWriteArrayList to update the list while iterating the list
		List<String> list = new CopyOnWriteArrayList<String>();
		
		list.add("a");
		list.add("b");
		
		// now iterate list using iterator
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
			// now update the list while iterating the list we will get ConcurrentModificationException
			list.add("c");
		}
		
		//System.out.println(list);
	}

}
