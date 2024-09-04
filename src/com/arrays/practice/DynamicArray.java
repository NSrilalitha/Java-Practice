package com.arrays.practice;

/**
 * In java ArrayList is a dynamic array which increases or decreases its
 * capacity based on the array size. Here this class contains implementation of
 * ArrayList from scratch.
 * 
 * A dynamic array implementation based on a static array.
 */
public class DynamicArray {

	// underlying static array
	private char[] array;

	// current number of elements in the array
	private int size;

	// Maximum number of elements the array can hold without resizing
	private int capacity;

	/**
	 * Constructs a new dynamic array with the given initial capacity.
	 */
	public DynamicArray(int capacity) {
		this.array = new char[capacity];
		this.size = 0;
		this.capacity = capacity;
	}

	/**
	 * Returns the value at the given index in the dynamic array.
	 */
	public char get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	/**
	 * Sets the value at the given index in the dynamic array to the given value.
	 */
	public void set(int index, char value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		array[index] = value;
	}

	/**
	 * Adds a new value to the end of the dynamic array.
	 */
	public void add(char value) {
		if (size == capacity) {
			// ArrayList doubles its capacity when the array is full
			resize(capacity * 2);
		}
		array[size++] = value;
	}
	
	/**
	 * Adds a new value at the specified index in the dynamic array.
	 */
	public void add(int index, char value) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == capacity) {
			resize(capacity*2);
		}
		// Moves all elements from the specified 'index' to the end of the array one position to the right in the array
		System.arraycopy(array, index, array, index+1, size-index);
		array[index] = value;
		size++;
	}
	
	/**
	 * Removes the value at the given index from the dynamic array.
	 */
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Shifts all elements after 'index' one position to the left, overwriting the element at 'index' and effectively removing it.
		System.arraycopy(array, index+1, array, index, size-index-1);
		size--;
		if (size < capacity/2 && capacity>1) {
			resize(capacity/2); // reducing the capacity to half of its capacity
		}
	}
	
	/**
	 * Returns the current size of the dynamic array
	 */
	public int size() {
		return size;
	}

	/**
	 * Adjusts the capacity of the dynamic array by creating a new array with the given capacity,
	 * copying the elements from the old array to the new array, and updating the capacity and reference
	 * the old array.
	 */
	private void resize(int newCapacity) {
		char[] newArray = new char[newCapacity];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
		capacity = newCapacity;
		
	}

}
