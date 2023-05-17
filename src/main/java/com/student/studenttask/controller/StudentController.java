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

    // Autowiring Dependency

    @Autowired
    public void getService(StudentService studentService){
        this.studentService = studentService;
    }


    // Mapping

    @GetMapping("/")
    public String homePageMapping(){
        return "Home Page View";
    }

    @GetMapping("/allstudents")
    public ResponseEntity<?> getAllStudentsMapping(){
        List<StudentDto> studentDtoList = studentService.getAllStudents();

        if(studentDtoList != null){
            return ResponseEntity.accepted().body(studentDtoList);
        }

        // if list is empty
        return ResponseEntity.accepted().body("Student List is Empty");
    }

}
