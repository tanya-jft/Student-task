package com.student.studenttask.controller;


import com.student.studenttask.dto.StudentDto;
import com.student.studenttask.entity.Students;
import com.student.studenttask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public void getService(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String homePageMapping(){
        return "Home Page View";
    }

    // get all students
    @GetMapping("/allstudents")
    public List<StudentDto> getAllStudentsMapping(){
        List<StudentDto> studentDtoList = studentService.getAllStudents();
        return studentDtoList;
    }


}
