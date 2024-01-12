package com.sampleQuizApp.SampleApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String title;
    public Integer numQuestions;

    @ManyToMany
    public List<Question> questions;
}
