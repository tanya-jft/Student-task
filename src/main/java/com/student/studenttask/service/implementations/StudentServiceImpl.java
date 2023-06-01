package com.student.studenttask.service.implementations;


import com.student.studenttask.dto.StudentDto;
import com.student.studenttask.entity.Students;
import com.student.studenttask.repository.StudentRepo;
import com.student.studenttask.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentServiceInterface {

    private StudentRepo repo;

    // getting dependencies
    @Autowired
    public void getRepo(StudentRepo sRepo) {
        this.repo = sRepo;
    }


    // getting all students
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

    @Override
    public String addStudent(Students studentDto) {
        // with this we can save the student
        repo.save(studentDto);
//        return the string for reference
        return "Student Created ";
    }


}
