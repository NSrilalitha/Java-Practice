package com.abstraction.practice;

public class Dog extends AdapterExample {

    // now actually providing implementation of m1 method of Animal interface
    @Override
    public void m1() {
        System.out.println("in m1 method of Dog class");
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        d.m1();
    }
}
