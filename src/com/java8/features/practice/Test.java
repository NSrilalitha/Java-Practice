package com.java8.features.practice;

public class Test {

    String[] args = {"abc", "lalitha"};

    public static void main(String[] args) {

        System.out.println("length : " + args.length);

        Test ob = new Test();
        System.out.println("class level variable args length is "+ob.args.length);


        // What is the output of below program
        String s1 = "March";
        String s2 = "March";
        String s3 = s1;
        s1 = "April";
        s2.concat("May");
        String newS3 = s3.concat("June");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(newS3);
    }
}
