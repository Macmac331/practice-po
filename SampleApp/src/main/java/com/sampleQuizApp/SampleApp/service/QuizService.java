package com.sampleQuizApp.SampleApp.service;

import com.sampleQuizApp.SampleApp.model.QuestionWrapper;
import com.sampleQuizApp.SampleApp.model.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuizService {
    ResponseEntity<String> createQuiz(String difficulty, int numQuestion, String title);

    ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id);

    ResponseEntity<String> createRandomQuiz(Quiz quiz);
}
