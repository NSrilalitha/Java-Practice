package com.abstraction.practice;

public abstract class B extends A {

    public B() {
        System.out.println("B class Constructor");
    }

    String str = "hi";

    @Override
    void m1() {
        System.out.println("m1 method called");
    }

    void message() {
        System.out.println("in class B");
    }

}
