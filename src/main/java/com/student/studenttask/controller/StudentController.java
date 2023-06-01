package com.student.studenttask.controller;


import com.student.studenttask.dto.StudentDto;
import com.student.studenttask.entity.Students;
import com.student.studenttask.service.implementations.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private StudentServiceImpl studentServiceImpl;

    // Autowiring Dependency

    @Autowired
    public void getService(StudentServiceImpl studentServiceImpl){
        this.studentServiceImpl = studentServiceImpl;
    }


    // Mapping to get all the students

    @GetMapping("/")
    public String homePageMapping(){
        return "Home Page View";
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudentsMapping() {
        List<StudentDto> studentDtoList = studentServiceImpl.getAllStudents();

        if (studentDtoList != null) {
            return ResponseEntity.accepted().body(studentDtoList);
        }

        // if list is empty
        return ResponseEntity.accepted().body("Student List is Empty");
    }


    @PostMapping("/students")
    public String saveStudent(@RequestBody Students studentDto) {
        return studentServiceImpl.addStudent(studentDto);
    }

}
