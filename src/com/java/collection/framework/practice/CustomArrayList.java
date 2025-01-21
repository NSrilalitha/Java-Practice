
package com.java.collection.framework.practice;

import java.util.ArrayList;

/**
 * This class extends ArrayList class. The purpose of this class is to make
 * ArrayList that doesn't allow duplicate values in it.
 * 
 */
public class CustomArrayList extends ArrayList {

	// Overriding add method to provide our own implementation
	@Override
	public boolean add(Object e) {
		if (this.contains(e)) {
			return true;
		} else {
			return super.add(e);
		}
	}

	public static void main(String[] args) {
		// Now create list and add some values and check duplicates adding or not
		CustomArrayList list = new CustomArrayList();
		list.add(1);
		list.add(2);
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);

		// now print and check
		System.out.println(list);

	}

}
