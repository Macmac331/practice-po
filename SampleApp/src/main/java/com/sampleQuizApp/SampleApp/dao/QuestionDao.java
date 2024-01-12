package com.sampleQuizApp.SampleApp.dao;

import com.sampleQuizApp.SampleApp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT * FROM question WHERE difficulty = :difficulty ORDER BY RANDOM() LIMIT :numQuestion", nativeQuery=true)
    List<Question> findQuestionsByDifficulty(String difficulty, int numQuestion);
    @Query(value = "SELECT * FROM question ORDER BY RANDOM() LIMIT :numQuestions", nativeQuery = true)
    List<Question> findRandomQuestions(Integer numQuestions);
}
