package com.sampleQuizApp.SampleApp.controller;

import com.sampleQuizApp.SampleApp.model.Question;
import com.sampleQuizApp.SampleApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
@CrossOrigin
public class QuestionController {
    @Autowired  
    QuestionService questionService;
    @GetMapping("get-questions")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }
}
