/**
 * 
 */
package com.test.integer.type.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Srilalitha
 *
 */
public class FindFrequencyOfLetter {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter k digit");
		int k = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter length of array");
		int length = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter numbers");
		int[] arr = new int[length];
		for (int i=0;i<length;i++) {
			arr[i] = sc.nextInt();
			sc.nextLine();
		}
		sc.close();
		// Now find a number which is having maximum no of k digit
		int number = findNumberWithMaximumK(k, arr);
		System.out.println("Number with maximum k is "+ number);
	}

	private static int findNumberWithMaximumK(int k, int[] arr) {
		System.out.println("Method-1==========================");
		/*String number = "";
		String kDigit = String.valueOf(k);
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		int kCount = 0;
		
		// iterate through array
		for (int i=0;i<arr.length;i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			String num = String.valueOf(arr[i]);
			int count = 0;
			// iterate through num and find kDigit frequency
			for (int j=0;j<num.length();j++) {
				if (kDigit.equals(Character.toString(num.charAt(j)))) {
					System.out.println("character is "+num.charAt(j));
					map.put(num, ++count);
					System.out.println("===============");
					System.out.println(map.toString());
				}
			}
			// countMap holds count of K digit in each number given in array
			countMap.put(num, map.get(num));
			System.out.println("===============count Map output=====");
			System.out.println(countMap.toString());
		}
		
		// now find for which number k count is high
		if (!countMap.isEmpty()) {
			Set<Entry<String, Integer>> entrySet = countMap.entrySet();
			for (Entry<String, Integer> entry : entrySet) {
				int value = 0;
				if (null != entry.getValue()) {
					value = entry.getValue().intValue();
				}
				if (value > kCount) {
					kCount = value;
					number = entry.getKey();
				}
			}
			
			return Integer.parseInt(number);
		}*/
		System.out.println("Method-2==================================");
		String kDigit = String.valueOf(k);
		int count = 0;
		int number = 0;
		for(int i=0; i<arr.length;i++) {
			String num = String.valueOf(arr[i]);
			
			char[] charArr = num.toCharArray();
			List<Character> list = new ArrayList<Character>();
			for (char ch: charArr) {
				list.add(new Character(ch));
			}
			int kCount = Collections.frequency(list, new Character(kDigit.charAt(0)));
			if (kCount > count) {
				count = kCount;
				number = arr[i];
			}
		} 
		// To convert int[] array to List<Integer> we can use java 8 streams
		//List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		return number;
	}

}
