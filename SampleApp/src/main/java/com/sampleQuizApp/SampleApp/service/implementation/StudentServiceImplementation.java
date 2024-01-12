package com.sampleQuizApp.SampleApp.service.implementation;

import com.sampleQuizApp.SampleApp.dao.StudentDao;

import com.sampleQuizApp.SampleApp.model.Student;
import com.sampleQuizApp.SampleApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Override
    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }

    @Override
    public ResponseEntity<String> createStudent(Student student){
        studentDao.save(student);
        try{
            return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Saving Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
