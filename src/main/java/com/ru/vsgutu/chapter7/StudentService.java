package com.ru.vsgutu.chapter7;

import java.util.List;

public interface StudentService {
    List<Student> getSortedStudentsByNameAndByGradeAbove(List<Student> students, int grade);
}
