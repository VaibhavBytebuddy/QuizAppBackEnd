package com.Byte.Buddy.QuizAppByMe.controller;

import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import com.Byte.Buddy.QuizAppByMe.entity.Quiz;
import com.Byte.Buddy.QuizAppByMe.entity.QuizQuestion;
import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.service.QuestionService;
import com.Byte.Buddy.QuizAppByMe.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/quizzes")
@CrossOrigin(origins = "http://localhost:3000")
public class QuizController {



    @Autowired
    private QuizService quizService;

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz)
    {
        List<QuizQuestion> quizQuestions=quiz.getQuizQuestions();
        for (QuizQuestion quizQuestion : quizQuestions)
        {
            quizQuestion.setQuiz(quiz);
        }
        return quizService.creteQuiz(quiz);
    }

    @GetMapping("/{id}")
    public Quiz  getQuizById(@PathVariable Long id)
    {
        return quizService.getQuizById(id);
    }
    @PutMapping("/{id}")
    public Quiz updateQuiz(@PathVariable Long id,@RequestBody Quiz quiz)
    {
        return quizService.updateQuiz(id,quiz);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteQuiz(@PathVariable Long id)
    {
        quizService.deleteQuizByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Quiz> getAllQuizzes()
    {
        return quizService.getAllQuizzes();

    }

    @GetMapping("/getQuizQuestById/{id}")
    public List<Questions> getQuizQuestById(@PathVariable Long id)
    {

        System.out.println("Inside Get Quiz quest by Id");
        return quizService.getQuizQuestById(id);
    }


}
