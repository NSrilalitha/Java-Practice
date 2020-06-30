package com.java.collection.framework.practice;

import java.time.LocalDate;

/**
 * This class demonstrates java 8 Date API 
 * 
 * @author Srilalitha
 *
 */
public class DateApiExample {
	
	public static void main(String[] args) {

		// creating date
		LocalDate date = LocalDate.of(2020, 05, 8); // today's date: 08/05/2020 i.e., May 8th 2020
		// print day name
		// Here DayOfWeek is enum present in LocalDate
		String dayName = date.getDayOfWeek().name();

		System.out.println(dayName);
	}
}
