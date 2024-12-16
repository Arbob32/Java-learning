package com.ru.vsgutu.chapter7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {
    private final StudentServiceImpl studentService = new StudentServiceImpl();

    @Test
    public void testStudentService() {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Student6", 10));
        students.add(new Student("Student1", 9));
        students.add(new Student("Student2", 8));
        students.add(new Student("Student3", 7));
        students.add(new Student("Student4", 9));
        students.add(new Student("Student5", 10));

        students = studentService.getSortedStudentsByNameAndByGradeAbove(students, 8);

        assertEquals("Student1", students.get(0).getName());
        assertEquals(4, students.size());
    }
}
