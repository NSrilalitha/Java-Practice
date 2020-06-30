package com.sorting.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of prices and an amount to spend, what is the maximum number of
 * toys Mark can buy? For example, if prices = [1,2,3,4] and Mark has price=7 to
 * spend, he can buy items [1,2,3] for 6, or [3,4] for 7 units of currency. He
 * would choose the first group of items.
 * 
 * Reference: https://www.hackerrank.com/challenges/mark-and-toys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * 
 * @author Srilalitha
 *
 */
public class FindMaxToysForPrice {

	public static void main(String[] args) {
		
		int price = 7;
		// prices of toys given as array
		int[] prices = {1,2,3,4};
		
		// now find how many maximum no of toys we can buy for given price
		// [1,2,3] or [2,3] or [3,4] but [1,2,3] he is getting more toys 
		
		
		// using java 8 streams to perform following tasks on given array
        // sorting the array
        // after sorting filtering the array to get only elements less than given price
        // taking filtered output as another new array
		int[] narr = Arrays.stream(prices).sorted().filter(num -> num<price).toArray();
		
		// if none of the prices of toys are lesser than given price then return 0
		if(narr.length == 0) {
			System.out.println("None of the toys he can't buy");
		}
		
		// if only one toy price is available and lesser than given price then return 1
		if (narr.length == 1) {
			System.out.println("he can buy 1 toy");
		}	
		
		List<String> toyPrices = new ArrayList<>();
		
		for (int i = 0; i < narr.length - 1; i++) {
			String str = "";
			int sum = narr[i];
			str = str + narr[i];
			for (int j = i; (sum < price) && (j < narr.length - 1); j++) {
				sum = sum + narr[j+1];
				if (sum <= price) {
					str = str + "," + narr[j+1];
				}	
			}
			toyPrices.add(str);
		}
		
		int count = 0;
		for (int i=0;i<toyPrices.size();i++) {
			String[] sarr = toyPrices.get(i).split(",");
			if (sarr.length > count) {
				count = sarr.length;
			}
		}
		
		System.out.println("he can buy " + count + " toys");
			
	}
}
