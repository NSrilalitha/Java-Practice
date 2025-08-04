package com.java8.features.practice;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Person implements Comparable {

    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(@NotNull Object o) {
        // this method decides whether objects are equal or not while sorting, if same then its a duplicate, that won't get added to llist
        // sort the Person object by their name and then age
        Person p = (Person) o;
        int cmp = this.name.compareTo(p.name);
        // if name is same then compare age
        if(cmp == 0) {
            // We have compare method in Integer wrapper class to compare integers
            return Integer.compare(this.age, p.age);
        }
        return cmp;
    }
}
