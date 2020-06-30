/**
 * 
 */
package com.string.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Srilalitha
 *
 */
public class ReverseStringProgram {

	public void printMessage(String message) {
		System.out.println("hello "+message);
	}
	
	public void printMessage(Object message) {
		System.out.println(message);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of test cases");
		int t = sc.nextInt();
		sc.nextLine();
		
		while(t!=0) {
			// now read string
			System.out.println("read string");
			String str = sc.nextLine();
			
			// split string with . as delimiter
			String[] arr = str.split("\\.");
			System.out.println(Arrays.toString(arr));
			
			// printing words in a string in reverse direction
			System.out.println("------------Printing words of sentence in reverse direction------");
			for(int i=arr.length-1;i>=1;i--) {
				System.out.print(arr[i]+".");
			}
			System.out.print(arr[0]);
			System.out.println();
			t--;
		}
		
		System.out.println("------------Demo on removing substring in a string---------");
		String str1 = "abfkidjldjilfjilejklwe";
		// to remove any substring in a string we can make use of replace as shown below
		String str2 = str1.replace("fji", "");
		System.out.println(str2);
		
		
		StringBuilder sb = new StringBuilder(str1);
		// To know the index of substring we can use indexOf method
		// indexOf method available in String class as well.
		System.out.println("index of substring is : "+ sb.indexOf("fji"));
		
		System.out.println("----------Demo on replace method----------");
		
		String s1 = "abchellodefhellojkihello";
		// replace method replaces all occurances of string with given string
		s1 = s1.replace("hello", "hi");
		System.out.println(s1);
		
		System.out.println("---------------Demo on replaceFirst method----------");
		// replaceFirst replaces only first occurance of string with given string
		String s2 = "abchellodefhellojkihello".replaceFirst("hello", "hi");
		System.out.println(s2);
		
		ReverseStringProgram  obj = new ReverseStringProgram();
		obj.printMessage("abc");
		// when we pass null as argument, String can be null and Object can be null
		// but String class is more appropriate so the method with String as argument gets called
		obj.printMessage(null);
	
	}

}

