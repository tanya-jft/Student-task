package com.student.studenttask.service;


import com.student.studenttask.dto.StudentDto;
import com.student.studenttask.entity.Students;
import com.student.studenttask.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepo repo;

    @Autowired
    public void getRepo(StudentRepo sRepo) {
        this.repo = sRepo;
    }


    // getting all students
    public List<StudentDto> getAllStudents(){
        List<Students> studentList = repo.findAll();

        if(!studentList.isEmpty()){
            // convert the student entity to student DTO
            List<StudentDto> studentDto = studentList.stream()
                    .map(student -> new StudentDto(
                            student.getId(),
                            student.getFullName() ,
                            student.getTotalMarks()))
                    .collect(Collectors.toList());

            return studentDto;
        }

        return null;
    }

}
