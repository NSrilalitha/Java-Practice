package com.java8.features.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestFunctionalInterface {

    public static void main(String[] args) throws IOException {

        // read two numbers using Scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number : ");
        int a = sc.nextInt();
        System.out.println("Enter second number : ");
        int b = sc.nextInt();

        // From java 8 : Using lambda expression to provide implementation for functional interface

        // providing sum method implementation through lambda expression
        AddInterface addition = (x, y) -> x + y;
        /*
         the above lambda can be replaced with method reference also. refer below
         AddInterface addition = Integer::sum;
        */

        AdditionInterface additionInterface = (x,y,z) -> x+y+z;

        // now invoke sum method, which is calculated using lambda expression
        int value = addition.sum(a,b);
        System.out.println("sum of two numbers is " +value);

        int sumOf3Numbers = additionInterface.sumOfThreeNumbers(5,12,8);
        System.out.println("sum of three numbers is "+sumOf3Numbers);

        // before Java 8

        // using BufferedReader to read input as String, then call static method present in interface
        // to convert it to int and find sum
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // providing sum method implementation through child class (before java 8)
        AddInterface addition1 = new AddImpl();

        try {
            System.out.println("Enter num1 : ");
            int num1 = AddInterface.number(reader.readLine());
            System.out.println("Enter num2 : ");
            int num2 = AddInterface.number(reader.readLine());

            // now invoke sum method, which is implemented using child class
            int value1 = addition1.sum(num1,num2);

            System.out.println("sum of two numbers calculated using child class is "+value1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sc.close();
        reader.close();
    }

}
