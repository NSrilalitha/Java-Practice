package com.exception.handling.practice;

public class ExceptionInheritanceExample {

	public static void main(String[] args) {
		
		try {
			// throw dog exception
			throw new DogException();
		} catch (AnimalException ae) {
			System.out.println(ae);
		} catch (Exception e) {
			System.out.println("exception");
		}
	}
}


class AnimalException extends Exception {

	AnimalException() {
		super();
	}

	@Override
	public String toString() {
		return "Animal exception thrown";
	}

}

class DogException extends AnimalException {

	DogException() {
		super();
	}

	@Override
	public String toString() {
		return "Dog exception thrown";
	}

}
