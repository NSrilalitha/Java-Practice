package com.string.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Find max consecutive 1's count in given binary number;
 * 
 * @author Srilalitha
 *
 */
public class RegexMatcherExample {

	public static void main(String[] args) {
		
		String str = "110111";
		
		// Now find consecutive 1's count in given string
		Pattern pattern = Pattern.compile("11+");
		Matcher matcher = pattern.matcher(str);
		
		int count = 0;
		while (matcher.find()) {
			String str1 = matcher.group(0);
			System.out.println("string is " + str1);
			if (str1.length() > count) {
				count = str1.length();
			}
		}
		
		if (count == 0 && str.contains("1")) {
			count = 1;
		}
		System.out.println(count);
		
	}
}
