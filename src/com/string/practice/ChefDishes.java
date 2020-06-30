package com.string.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ChefDishes {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int noOfDays = in.nextInt();
		in.nextLine();
		
		List<String> ingredients = new ArrayList<String>();
		for (int i=0;i<noOfDays;i++) {
			String ingredient = in.next();
			ingredients.add(ingredient);	
		}
		
		String result = "";
		if (noOfDays == 1) {
			System.out.println("0");
		} else if (noOfDays == 2) {
			System.out.println("00");
		} else {
			if (noOfDays == 3) {
				result = findResult(noOfDays, ingredients);
			}
		}
		
	}

	private static String findResult(int noOfDays, List<String> ingredients) {
		List<String> list = new ArrayList<String>();
		for (int i=0;i<noOfDays;i++) {
			if(ingredients.get(i).startsWith("FIBER")) {
				list.add("FIBER");
			} else if(ingredients.get(i).startsWith("FAT")) {
				list.add("FAT");
			} else {
				list.add("CARB");
			}
		}
		
		long count = list.stream().filter(str -> str.equals("FIBER") || str.equals("FAT") || str.equals("CARB")).count();
		System.out.println("count is "+count);
		return null;
	}
}
