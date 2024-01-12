package com.sampleQuizApp.SampleApp.service;

import com.sampleQuizApp.SampleApp.model.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuestionService {
    List<Question> getAllQuestions();

    ResponseEntity<String> createQuestion(Question question);
}
