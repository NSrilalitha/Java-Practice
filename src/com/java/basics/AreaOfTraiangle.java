package com.java.basics;


import java.util.Scanner;

/**
 * This program is to calculate the area of a traingle having 3 sides a,b,c.
 */
public class AreaOfTraiangle {

    public static void main(String[] args) {
        int a,b,c;
        double s,area;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of triangle: ");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        s = (double) (a + b + c) /2;
        area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        System.err.println("The area of the triangle is "+area);
    }
}
