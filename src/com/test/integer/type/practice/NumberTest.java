package com.test.integer.type.practice;

import java.util.Arrays;

public class NumberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		Integer number = new Integer(num);
		int size = number.SIZE;
		System.out.println(size);
		
		String s1 = "7237";
		String str = s1.replaceAll("7", "");
		System.out.println(str);
	}

}
