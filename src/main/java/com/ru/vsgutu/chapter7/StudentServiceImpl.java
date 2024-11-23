package com.ru.vsgutu.chapter7;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getSortedStudentsByNameAndByGradeAbove(List<Student> students, int grade) {
        return students.stream()
                .filter(student -> student.getGrade() > grade)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }
}
