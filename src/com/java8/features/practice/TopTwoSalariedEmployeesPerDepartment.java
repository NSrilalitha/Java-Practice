package com.java8.features.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find top two salaried employees per department
 */
public class TopTwoSalariedEmployeesPerDepartment {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sri", 25000, "HR"),
                new Employee(2, "Priya", 25000, "Finance"),
                new Employee(3, "Radha", 10000, "HR"),
                new Employee(4, "Abhi", 40000, "HR"),
                new Employee(5, "Geetha", 40000, "Finance"),
                new Employee(6, "Venkat", 30000, "Auditing"),
                new Employee(7, "Sudha", 10000, "Auditing"));


        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list ->
                                        list.stream()
                                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                                .limit(2)
                                                .collect(Collectors.toList())

                        )
                ));
        System.out.println(map);



        /*
        // Finding second highest salaried employee per department
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((dept,list) -> System.out.println(dept + " -> " +
                        list.stream()
                                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                                .skip(1)
                                .findFirst()
                                .orElse(null)
                ));

            */
    }
}
