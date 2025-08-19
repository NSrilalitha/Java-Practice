package com.java8.features.practice;

/**
 * This is a custom functional interface, it has one abstract method sum which returns int and one static method number which returns number in int format.
 */
@FunctionalInterface
public interface AddInterface {

    public abstract int sum(int a, int b);

    /**
     * This is a utility helper method, to parse the string to int form
     */
    public static int number(String value) {
        // parse the given number which is in string format and convert to int
        return Integer.parseInt(value);
    }
}
