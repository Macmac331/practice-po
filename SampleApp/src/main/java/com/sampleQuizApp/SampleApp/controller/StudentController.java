package com.sampleQuizApp.SampleApp.controller;

import com.sampleQuizApp.SampleApp.model.Student;
import com.sampleQuizApp.SampleApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;
    @GetMapping("get-students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }
    @PostMapping("create")
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
