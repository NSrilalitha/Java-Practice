package com.sorting.practice;

import java.util.Objects;

public class Student {

    private int roll_no;

    private String name;

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return roll_no == student.roll_no && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roll_no, name);
    }

    public Student(String name, int roll_no) {
        this.name = name;
        this.roll_no = roll_no;
    }
}
