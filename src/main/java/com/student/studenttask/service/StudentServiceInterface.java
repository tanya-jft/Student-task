package com.student.studenttask.service;


import com.student.studenttask.dto.StudentDto;
import com.student.studenttask.entity.Students;

import java.util.List;


public interface StudentServiceInterface {

    public List<StudentDto> getAllStudents();
    public String addStudent(Students studentDto);

    String deleteStudent(Integer sid);

    String updateStudent(Students students);
}
