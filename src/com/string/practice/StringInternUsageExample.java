package com.string.practice;

public class StringInternUsageExample {
    public static void main(String[] args) {
        // here s1 object should be saved in object pool in heap memory
        String s1 = new String("Hello");
        // now s2 will have s1 data but the object refers to string constant pool memory
        String s2 = s1.intern();
        System.out.println(s2);
        // check their references same or not. it should not be same \
        System.out.println(s1==s2);
    }
}
