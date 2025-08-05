package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem : solve this problem using java 8 streams :
 * list of employee objects, each employee object has id,name,salary. Now return list of employees who has same salary.
 *
 *  eg: if two employees have 25000 and three employees have 10000 and one employee has 40000 and 2 employees have 5000. now we need to give employees who have same salary
 */
public class FindSameSalariedEmployees {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"Sri",25000),
                new Employee(2,"Priya",25000),
                new Employee(3, "Radha",10000),
                new Employee(4,"Abhi",40000),
                new Employee(5,"Geetha",40000),
                new Employee(6,"Venkat",30000),
                new Employee(7,"Sudha",10000)
        );

        List<Employee> duplicateSalariedEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee :: getSalary)) //Map<Integer,List<Employee>>
                .values().stream()
                .filter(list -> list.size()>1)
                .flatMap(List::stream) // flattens Stream of lists to single stream of Employees
                .collect(Collectors.toList());

        duplicateSalariedEmployees.forEach(System.out::println);
    }
}
