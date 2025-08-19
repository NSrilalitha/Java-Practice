package com.java8.features.practice;

import java.util.*;
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
                new Employee(1,"Sri",25000,"HR"),
                new Employee(2,"Priya",25000,"Finance"),
                new Employee(3, "Radha",10000,"HR"),
                new Employee(4,"Abhi",40000,"HR"),
                new Employee(5,"Geetha",40000,"Finance"),
                new Employee(6,"Venkat",30000,"Auditing"),
                new Employee(7,"Sudha",10000,"Auditing")
        );

        // Problem -1: Get list of employees who has same salary
        List<Employee> duplicateSalariedEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee :: getSalary)) //Map<Integer,List<Employee>>
                .values().stream()
                .filter(list -> list.size()>1)
                .flatMap(List::stream) // flattens Stream of lists to single stream of Employees
                .collect(Collectors.toList());

        duplicateSalariedEmployees.forEach(System.out::println);


        // problem -2: Group employees by their department
        Map<String, List<Employee>> groupingByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println(groupingByDepartment);

        groupingByDepartment.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary)) // Sorting the employees based on department first and then salary
                .forEach(System.out::println);


        // Problem -3: Sort the employees by their Department using built-in function
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .forEach(System.out::println);

        // sort the employees by their department without using built-in functions, write custom logic


    }
}
