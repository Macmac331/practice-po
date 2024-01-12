package com.sampleQuizApp.SampleApp.service;

import com.sampleQuizApp.SampleApp.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    ResponseEntity<String> createStudent(Student student);
}
