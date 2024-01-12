package com.sampleQuizApp.SampleApp.controller;

import com.sampleQuizApp.SampleApp.model.QuestionWrapper;
import com.sampleQuizApp.SampleApp.model.Quiz;
import com.sampleQuizApp.SampleApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@CrossOrigin
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create-quiz")
    public ResponseEntity<String> createQuiz(@RequestParam String difficulty,
                                             @RequestParam Integer numQuestion,
                                             @RequestParam String title){
        return quizService.createQuiz(difficulty,numQuestion,title);
    }
    @PostMapping("create/random")
    public ResponseEntity<String> createRandomQuiz(@RequestBody Quiz quiz){
        return quizService.createRandomQuiz(quiz);
    }

    @GetMapping("get/{Id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer Id){
        return quizService.getQuiz(Id);
    }
}
