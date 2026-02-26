package com.file.handling.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadLinesFromFile {

    public static void main(String[] args) {

        Path path = Paths.get("E:/Lalitha/codebase/abc.txt");

        try {
            Files.lines(path).forEach(System.out::println);
        } catch(IOException exception) {
            System.err.println("File doesn't exist : "+exception.getMessage());
        }



    }
}
