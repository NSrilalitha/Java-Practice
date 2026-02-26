package com.java8.features.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindMaxSalariedEmployee {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"Sri",25000,"HR"),
                new Employee(2,"Priya",25000,"Finance"),
                new Employee(3, "Radha",10000,"HR"),
                new Employee(4,"Abhi",40000,"HR"),
                new Employee(5,"Geetha",40000,"Finance"),
                new Employee(6,"Venkat",30000,"Auditing"),
                new Employee(7,"Sudha",10000,"Auditing"));


        Optional<Employee> highestSalariedEmployee = employees.stream()
                .max((e1, e2) -> e1.getSalary() - e2.getSalary());

        highestSalariedEmployee.ifPresent(System.out::println);

        // Problem-2: Find top 3 salaried employees
        List<Employee> top3Employees = employees.stream().sorted((e1,e2) -> e2.getSalary() - e1.getSalary()).limit(3).collect(Collectors.toList());
        System.out.println("Top 3 salaried employees are :");
        top3Employees.forEach(System.out::println);

        // Problem-3: Finding the bigger number from the given numbers
        int[] nums = new int[]{3,4,1,7,8,6};
        // using max for array of integers // for primitives Comparator is not required in max
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println(max);

        //getting max using reduce function
        int maximum = Arrays.stream(nums).reduce(Integer::max).getAsInt();
        System.out.println("Max element using reduce function : "+maximum);

        // using max for list of numbers
        List<Integer> numbers = Arrays.asList(4,5,3,2,8,9,11,2);
        numbers.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);
        // other variations as below
        numbers.stream().max(Integer::compare).ifPresent(System.out::println);
        numbers.stream().max(Integer::compareTo).ifPresent(System.out::println);
        numbers.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
    }
}
