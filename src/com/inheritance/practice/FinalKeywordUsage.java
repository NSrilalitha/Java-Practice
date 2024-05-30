package com.inheritance.practice;
/**
 * This program is to illustrate the initialization of final variable
 * Note: we can initialize the blank final variable only in the constructor block
 *
 *  @author Srilalitha
 */
public class FinalKeywordUsage {

    // Declaring a final variable but not initializing here
    final int a;

    // now initializing the final variable in constructor
    FinalKeywordUsage() {
        a = 10;
    }

    // now reinitializing the final variable through another constructor i.e., here final varaible is accessed at run time through instance
    FinalKeywordUsage(int a) {
        this.a = a;
    }


    public static void main(String[] args) {
        FinalKeywordUsage ob1 = new FinalKeywordUsage();
        FinalKeywordUsage ob2 = new FinalKeywordUsage(20);
        // now print a values and check those are different for runtime instances
        System.out.println(ob1.a);
        System.out.println(ob2.a);
    }
}