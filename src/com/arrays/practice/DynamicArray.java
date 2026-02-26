package com.arrays.practice;

/**
 * A simplified implementation of Java's ArrayList to demonstrate how dynamic
 * arrays work internally.
 *
 * <p><b>Important points about Java's ArrayList:</b></p>
 *
 * <ul>
 *   <li>ArrayList is backed by a resizable array that provides O(1) random access.</li>
 *
 *   <li>When the internal array becomes full, ArrayList increases its capacity
 *       by 50% (1.5x growth): newCapacity = oldCapacity + (oldCapacity >> 1).</li>
 *
 *   <li>ArrayList does NOT shrink automatically after removals. Capacity only
 *       decreases when trimToSize() is called explicitly.</li>
 *
 *   <li>Time complexity:
 *       <ul>
 *         <li>get/set → O(1)</li>
 *         <li>add(value) → amortized O(1)</li>
 *         <li>add(index) and remove(index) → O(n) due to element shifting</li>
 *         <li>contains/indexOf → O(n)</li>
 *       </ul>
 *   </li>
 *
 *   <li>Insertions and removals in the middle of the list are expensive because
 *       they require shifting elements.</li>
 *
 *   <li>ArrayList allows null values and is not thread-safe.</li>
 *
 *   <li>Iterator is fail-fast and throws ConcurrentModificationException
 *       if the list is structurally modified outside the iterator.</li>
 *
 *   <li>Valid indexes for access are 0 to size-1, and for insertion 0 to size.</li>
 * </ul>
 *
 * <p>This class mimics the dynamic resizing behavior of ArrayList but does not
 * implement every feature such as fail-fast iterators or thread safety.</p>
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
			// ArrayList increase its capacity by 50% i.e., 1.5x current capacity when the array is full
			grow();
		}
		array[size++] = value;
	}
	
	/**
	 * Adds a new value at the specified index in the dynamic array.
	 */
	public void add(int index, char value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == capacity) {
			// Grow by 1.5x, like ArrayList
			grow();
		}
		// Moves all elements from the specified 'index' to the end of the array one position to the right in the array
		System.arraycopy(array, index, array, index+1, size-index);
		array[index] = value;
		size++;
	}

	private void grow() {
		int newCapacity = capacity + (capacity >> 1);  // 1.5x growth
		if (newCapacity == capacity) {
			newCapacity++; // ensure growth when capacity = 1
		}
		resize(newCapacity);
	}

	/**
	 * Removes the value at the given index from the dynamic array.
	 */
	public void remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		// Shift elements left
		System.arraycopy(array, index + 1, array, index, size - index - 1);
		// Reduce size
		size--;
		array[size] = '\0'; // clear removed slot
	}
	
	/**
	 * Returns the current size of the dynamic array
	 */
	public int size() {
		return size;
	}

	/**
	 * Adjusts the capacity of the dynamic array by creating a new array with the given capacity,
	 * copying the elements from the old array to the new array, updating the reference to the old array.
	 */
	private void resize(int newCapacity) {
		char[] newArray = new char[newCapacity];
		System.arraycopy(array, 0, newArray, 0, size);
		array = newArray;
		capacity = newCapacity;
		
	}

}
