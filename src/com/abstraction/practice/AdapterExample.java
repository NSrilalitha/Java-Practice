package com.abstraction.practice;

/**
 * Adapter class contains empty implementation of methods presents inside interface
 */
public class AdapterExample implements Animal {

    @Override
    public void m1() {
    }

    @Override
    public void m2() {
    }

    void print() {
        System.out.println("In AdapterExample class") ;
    }

    public static void main(String[] args) {
        AdapterExample obj = new AdapterExample();
        obj.m1();
        obj.m2();
        obj.print();
    }
}
