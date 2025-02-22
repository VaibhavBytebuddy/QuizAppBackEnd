package com.Byte.Buddy.QuizAppByMe.service;


import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import com.Byte.Buddy.QuizAppByMe.entity.Quiz;
import com.Byte.Buddy.QuizAppByMe.entity.QuizQuestion;
import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.repository.QuestionRepository;
import com.Byte.Buddy.QuizAppByMe.repository.QuizQuestionRepository;
import com.Byte.Buddy.QuizAppByMe.repository.QuizRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;



    public Quiz creteQuiz(Quiz quiz) {

        return quizRepository.save(quiz);

    }
   

    public Quiz getQuizById(Long id) {

        return quizRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Quiz not found"));
    }


    public Quiz updateQuiz(Long id, Quiz updateQuiz) {
        Quiz quiz=getQuizById(id);
        quiz.setQuizName(updateQuiz.getQuizName());
        quiz.setTechnology(updateQuiz.getTechnology());

        return quizRepository.save(quiz);

    }

    

    public void deleteQuizByID(Long id) {

        Quiz quiz=getQuizById(id);

        quizRepository.delete(quiz);
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public List<Questions> getQuizQuestById(Long id) {

        System.out.println("Id"+id);
        List<QuizQuestion> quizQuesList=quizQuestionRepository.findByQuiz(getQuizById(id));
        List<Questions> questionsList=new ArrayList<>();
        for (QuizQuestion quizQues:quizQuesList)
        {
            Optional<Questions> optionalQuestions=questionRepository.findById(quizQues.getQuestion().getId());

            optionalQuestions.ifPresent(questionsList::add);
        }

        questionsList.forEach(q->System.out.println(q.getQuestionText()));
        return questionsList;
    }




}
