package com.sampleQuizApp.SampleApp.dao;

import com.sampleQuizApp.SampleApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao  extends JpaRepository<Student,Integer> {
}
