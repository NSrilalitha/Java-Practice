package com.string.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a string. We have to make that string equal to "BALLOON". To make it
 * equal we can remove characters in given string. After removal also if we
 * can't make it equal to "BALLON" then print "not there". If we can make that
 * string equal to "BALLOON" print how many characters removed
 * 
 * @author Srilalitha
 *
 */
public class Test1 {

	public static void main(String[] args) {
	
		String str = "BAOOXXLLNU";
		
		// target string
		String format = "BALLOON";
		char[] arr = format.toCharArray();
		Arrays.sort(arr);
		System.out.println(arr);
		
		List<Character> word = new ArrayList<Character>();
		StringBuilder sb = new StringBuilder(str);
		int count = 0;
		for (int i=0; i<sb.length();i++) {
			
			switch (sb.charAt(i)) {
			case 'B':
				word.add(sb.charAt(i));
				break;
			case 'A':
				word.add(sb.charAt(i));
				break;
			case 'L':
				word.add(sb.charAt(i));
				break;
			case 'O':
				word.add(sb.charAt(i));
				break;
			case 'N':
				word.add(sb.charAt(i));
				break;
			default:
				sb.deleteCharAt(i);
				count++;
			}
		} 
		
		Collections.sort(word);
		System.out.println(word);
		
		
		System.out.println(sb.toString());

	}

}
