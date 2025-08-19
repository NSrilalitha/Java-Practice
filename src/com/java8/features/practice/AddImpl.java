package com.java8.features.practice;

/**
 * This class implements AddInterface which is a functional interface, provide implementation for abstract method
 */
public class AddImpl implements AddInterface {

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

}
