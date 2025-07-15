package com.java8.features.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConvertToUppercase {

    public static void main(String[] args) {

        // problem-1 :	Convert all strings in a list to uppercase.
        List<String> words = Arrays.asList("latha","priya","sindu","madhu","harika");
        List<String> upWords = words.stream()
                                    .map(String::toUpperCase)
                                    .collect(Collectors.toList());
        upWords.forEach(System.out::println);

        // problem-2: Count Words Starting with ‘a’
        List<String> names = Arrays.asList("aparna","akila","bala","tanya","arun","kavita","Anand","kala","Arav");
        long aCount = names.stream()
                .filter(name -> name.trim().toLowerCase().startsWith("a"))
                .count();

        System.out.println("There are "+aCount+" names present in the list");

        // Problem-3: Find the first element in a list starting with "A".
        Optional<String> first = names.stream()
                .filter(name -> name.trim().startsWith("A"))
                .findFirst();

        // Note: Optional helps avoid NullPointerException and forces you to explicitly handle the absence of a value.
        System.out.println("First name starts with A : ");
        first.ifPresent(System.out::println); // it returns empty response if optional is empty, it will not throw NullPointerException

        // This is another approach to print the value of Optional
        String firstName = names.stream()
                .filter(name -> name.trim().startsWith("A"))
                .findFirst()
                .orElse("Not Present");

        System.out.println("First name starts with A: "+firstName);

    }
}

