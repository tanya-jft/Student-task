package com.student.studenttask.repository;

import com.student.studenttask.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Students, Integer> {

}
