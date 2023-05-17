package com.student.studenttask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private int id;
    private String fullName;
    private Integer totalMarks;
}
