package com.sampleQuizApp.SampleApp.service.implementation;

import com.sampleQuizApp.SampleApp.dao.QuestionDao;
import com.sampleQuizApp.SampleApp.model.Question;
import com.sampleQuizApp.SampleApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImplementation implements QuestionService {
    @Autowired
    QuestionDao questionDao;
    @Override
    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }
    public ResponseEntity<String> createQuestion(Question question){
        questionDao.save(question);
        try{
            return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Saving Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
