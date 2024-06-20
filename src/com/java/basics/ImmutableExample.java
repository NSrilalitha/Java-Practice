package com.java.basics;

/**
 * To make a class as immutable, we have to declare class as final, so we can't inherit it,
 * and declare instance variables as final and in constructor set the final variables, so the data wont be changed once it is set.
 */
public final class ImmutableExample {

    final int data;

    public ImmutableExample(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public static void main(String[] args) {
        // creating object
        ImmutableExample obj = new ImmutableExample(10);
        System.out.println(obj.getData());
        // now try to change the data, since it is final it wont allow you to change
        // obj.data = 20; // this statement gives compilation error

        // now create another object
        ImmutableExample obj2 = new ImmutableExample(20);
        System.out.println(obj2.getData());
    }
}


