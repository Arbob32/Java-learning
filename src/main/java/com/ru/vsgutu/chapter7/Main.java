package com.ru.vsgutu.chapter7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Student1", 10));
        students.add(new Student("Student2", 9));
        students.add(new Student("Student3", 8));
        students.add(new Student("Student4", 7));
        students.add(new Student("Student5", 9));
        students.add(new Student("Student6", 10));

        students.stream()
                .filter(student -> student.getGrade() > 8)
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }
}
