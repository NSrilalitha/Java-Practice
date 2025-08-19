package com.java8.features.practice;

/**
 * This functional interface has one abstract method which returns sum of three numbers.
 */
@FunctionalInterface
public interface AdditionInterface {

    int sumOfThreeNumbers(int a,int b,int c);

}
