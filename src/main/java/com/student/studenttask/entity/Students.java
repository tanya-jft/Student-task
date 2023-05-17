package com.student.studenttask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;


// lombok annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    // using wrapper Integer obj because typeID in Repository can not be primitive
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "total_marks")
    @Min(0)
    @Max(600)
    // use "int" instead of "Integer" because "int" can not store NULL value in itself.
    private int totalMarks;
}
