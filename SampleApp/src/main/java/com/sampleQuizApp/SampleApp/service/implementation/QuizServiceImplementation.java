package com.sampleQuizApp.SampleApp.service.implementation;

import com.sampleQuizApp.SampleApp.dao.QuestionDao;
import com.sampleQuizApp.SampleApp.dao.QuizDao;
import com.sampleQuizApp.SampleApp.model.Question;
import com.sampleQuizApp.SampleApp.model.QuestionWrapper;
import com.sampleQuizApp.SampleApp.model.Quiz;
import com.sampleQuizApp.SampleApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class QuizServiceImplementation implements QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    @Override
    public ResponseEntity<String> createQuiz(String difficulty, int numQuestion, String title){
        List<Question> questions = questionDao.findQuestionsByDifficulty(difficulty,numQuestion);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        try{
            return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
        }catch(Exception e){
            return  new ResponseEntity<>("Saving Failed", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuiz (Integer Id) {
        Optional<Quiz> quiz = quizDao.findById(Id);
        List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for (Question question : questionFromDB) {
            QuestionWrapper wrapper = new QuestionWrapper(question.getQuestion_id(), question.getQuestion_title(),
                    question.getOption_a(), question.getOption_b(), question.getOption_c(), question.getOption_d());
            questionForUser.add(wrapper);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> createRandomQuiz(Quiz quiz){
        String title = quiz.getTitle();
        Integer numQuestion = quiz.getNumQuestions();
        List<Question> questionList = questionDao.findRandomQuestions(numQuestion);
        Quiz randomQuiz = new Quiz();
        randomQuiz.setTitle(title);
        randomQuiz.setQuestions(questionList);
        try{
            quizDao.save(randomQuiz);
            return new ResponseEntity<>("Saved Successfully", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>("Saving Failed", HttpStatus.BAD_REQUEST);
        }
    }
}
