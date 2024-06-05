package com.abstraction.practice;

public abstract class B extends A {

    String str = "hi";

    @Override
    void m1() {
        System.out.println("m1 method called");
    }

    void message() {
        System.out.println("in class B");
    }

}
