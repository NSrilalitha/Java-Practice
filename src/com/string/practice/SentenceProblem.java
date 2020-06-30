package com.string.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SentenceProblem {

	public static void main(String[] args) {
		
		String sentence = "Aibohphobia is a joke term used to describe the fear of palindromes.";
		int length = sentence.length();
		// getting copy of sentence using substring
		String sent = sentence.substring(0, length-1);
		
		// split sentence using \s+ whitespace delimiter
		String[] arr = sent.split("\\s+");
		
		List<String> list = new ArrayList<String>();
		for(String str: arr) {
			str = str.toLowerCase();
			list.add(str.length() + " " + str);
		}
		// sorting words based on their length
		Collections.sort(list, new CustomComparator());
		
		System.out.println(list.toString());
		
		
		// printing first word by making first letter of word as capital
		String firstWord = "";
		// Approach-2: Using scanner to split length and word
		Scanner scan = new Scanner(list.get(0));
		while (scan.hasNext()) {
			String word = scan.next();
			// If it is not digit then take that word
			if (word.matches("\\D+")) {
				firstWord = word;
				break;
			}
		}
		System.out.println("First word using scanner :" + firstWord);
		scan.close();
	}

}

/*
 * Sorts the strings based on their length
 */
class CustomComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// Here each string contains a number and space and word
		String[] s1 = o1.split("\\s+");
		String[] s2 = o2.split("\\s+");
		
		if (!(s1[0] == s2[0])) {
			return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
		} 
		return 0;
	}
	
}

