package com.java.basics;

/**
 * This program is to illustrate initialization of local variable and usage of class variables
 */
public class LocalVariableInitialization {

    // now declaring a class variable i.e., outside of any method or block
    int a;
    String str;
    boolean b;

    void printMessage() {
        String s = "hi";
        // here without initializing s we cannot use this variable. try to print s without
        // initializing print s, will get compilation error
        System.out.println(s);
    }

    public static void main(String[] args) {
        LocalVariableInitialization ob = new LocalVariableInitialization();
        // now try to print class variables without initializing, by default we get default values,
        // we dont get any errors here. but for local variables without initialization we cant use them
        System.out.println(ob.a);
        System.out.println(ob.str);
        System.out.println(ob.b);
        ob.printMessage();
    }
}
