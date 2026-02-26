package com.abstraction.practice;

/**
 * Note: In Java, an abstract class can have a constructor, but we cannot instantiate an
 * abstract class directly.
 */
public class AbstractionAchiever extends B {

    String str = "hello";

    public AbstractionAchiever() {
        System.out.println("In AbstractionAchiever class constructor");
    }

    @Override
    void m2() {
        System.out.println("in m2 method");
    }

    void message() {
        // to call message method present in B class
        super.message();
        System.out.println("in AbstractionAchiever class");
    }

    public static void main(String[] args) {
        AbstractionAchiever obj = new AbstractionAchiever();
        obj.m2();
        obj.m1();
        System.out.println(obj.str);
        // calling message method overridden in this class
        obj.message();
        // to call str variable of B class
        B b = new AbstractionAchiever();
        System.out.println(b.str); // method overriding not applicable to variables
        //b.message();

    }
}
