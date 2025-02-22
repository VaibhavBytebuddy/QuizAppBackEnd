package com.Byte.Buddy.QuizAppByMe.controller;

import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import com.Byte.Buddy.QuizAppByMe.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public Questions createQuestion(@RequestBody Questions question)
    {
        return questionService.createQuestion(question);
    }

    @GetMapping("/{id}")
    public Questions getQuestion(@PathVariable Long id)
    {

        return questionService.getQuestionById(id);
    }

    @PutMapping("/{id}")
    public Questions updateQuestion(@PathVariable Long id,@RequestBody Questions question)
    {
        return questionService.updateQuestion(id,question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id)
    {
         questionService.deleteQuestionById(id);
    }

    @GetMapping("/getAllQuestion")
    public List<Questions> getAllQuestions()
    {
        return questionService.getAllquestions();
    }


}
