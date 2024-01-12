package com.sampleQuizApp.SampleApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer question_id;
    private String question_title;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private String correct_answer;
    private String difficulty;
    private String category;
}
