package com.student.studenttask.service.implementations;


import com.student.studenttask.dto.StudentDto;
import com.student.studenttask.entity.Students;
import com.student.studenttask.repository.StudentRepo;
import com.student.studenttask.service.StudentServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    private StudentRepo repo;

    private final ModelMapper mapper;

    public StudentServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    // getting dependencies
    @Autowired
    public void getRepo(StudentRepo sRepo) {
        this.repo = sRepo;
    }


    // getting all students
    // getting all students
    // getting all studentsc
    @Override
    public List<StudentDto> getAllStudents(){
        List<Students> studentList = repo.findAll();

        if(!studentList.isEmpty()){
            // convert the student entity to student DTO
            List<StudentDto> studentDto = studentList.stream()
                    .map(student -> new StudentDto(
                            student.getId(),
                            student.getFullName(),
                            student.getTotalMarks()))
                    .collect(Collectors.toList());

            return studentDto;
        }
        return null;
    }


    //add student function
    //add student function
    @Override
    public String addStudent(Students studentDto) {
        // with this we can save the student
        repo.save(studentDto);
//        return the string for reference
        return "Student Created ";
    }

    //delete student function
    @Override
    public String deleteStudent(Integer sid) {
        Students students = repo.findById(sid).orElseThrow(() -> new RuntimeException("Student not Found"));
        repo.delete(students);
        return "Student Deleted ";
    }


    //update student function
    //update student function
    @Override
    public String updateStudent(Students students) {
        Students currentStudent = repo.findById(students.getId()).orElseThrow(() -> new RuntimeException("Student not Found"));
        mapper.map(students, currentStudent);
        return "Student Updated";
    }


}
