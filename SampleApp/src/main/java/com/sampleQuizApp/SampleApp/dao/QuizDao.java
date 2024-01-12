package com.sampleQuizApp.SampleApp.dao;

import com.sampleQuizApp.SampleApp.model.Question;
import com.sampleQuizApp.SampleApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

    @Query(value = "SELECT * FROM question ORDER BY RANDOM() LIMIT :numQuestions", nativeQuery = true)
    List<Question> findRandomQuestions(Integer numQuestions);
}
