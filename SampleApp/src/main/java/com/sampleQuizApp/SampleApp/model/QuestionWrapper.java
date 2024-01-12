package com.sampleQuizApp.SampleApp.model;

import lombok.Data;

@Data
public class QuestionWrapper {

    private Integer question_id;

    public QuestionWrapper(Integer question_id, String question_title, String option_a, String option_b, String option_c, String option_d) {
        this.question_id = question_id;
        this.question_title = question_title;
        this.option_a = option_a;
        this.option_b = option_b;
        this.option_c = option_c;
        this.option_d = option_d;
    }

    private String question_title;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
}
