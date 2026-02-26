package com.java8.features.practice;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a list of lowercase strings, return the list of characters that appear in every strings
 */
public class FindMatchingChars {

    public static void main(String[] args) {

        List<String> words = List.of("bella","label","roller");

        List<Character> matchingChars = words.stream()
                .map(word -> // mapping each word to its character frequency map i.e., string -> Map<Character,Long>
                        word.chars()
                                .mapToObj(c -> (char)c)
                                .collect(Collectors.groupingBy(c -> c,Collectors.counting())))
                .reduce((map1,map2) -> { //comparing maps using reduce
                    map1.keySet().retainAll(map2.keySet());
                    map1.replaceAll((k,v) -> Math.min(v, map2.get(k)));
                    return map1;
                })
                .orElse(Map.of())
                .entrySet().stream()
                .flatMap(e -> Collections.nCopies(e.getValue().intValue(),e.getKey()).stream())
                .collect(Collectors.toList());

            System.out.println(matchingChars);

    }
}
