package com.Byte.Buddy.QuizAppByMe.controller;

import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.entity.UserAnswerDTO;
import com.Byte.Buddy.QuizAppByMe.entity.UserAnswers;
import com.Byte.Buddy.QuizAppByMe.repository.QuestionRepository;
import com.Byte.Buddy.QuizAppByMe.repository.UserAnswerRepository;
import com.Byte.Buddy.QuizAppByMe.repository.UserRepository;
import com.Byte.Buddy.QuizAppByMe.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-answers")
@CrossOrigin(origins = "http://localhost:3000")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;



    @Autowired
    private UserRepository userRepository;


    @Autowired
    private QuestionRepository questionRepository;


    @Autowired
    private UserAnswerRepository userAnswerRepository;





    @PostMapping
    public UserAnswers createUserAnswer(@RequestBody UserAnswerDTO userAnswerDto) {

        Optional<User> optionalUser = userRepository.findById(userAnswerDto.getUserId());

        User user = null;
        if(optionalUser.isPresent())
        {
             user=optionalUser.get();
        }



//        User user = userRepository.findById(userAnswerDto.getUserId())
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));

//        Questions question = questionRepository.findById(userAnswerDto.getQuestionId())
//                .orElseThrow(() -> new IllegalArgumentException("Question not found"));

       Optional<Questions> optionalQuestions = questionRepository.findById(userAnswerDto.getQuestionId());
        Questions question=null;
        if(optionalQuestions.isPresent())
        {
            question=optionalQuestions.get();
        }


        UserAnswers userAnswer = new UserAnswers();
        userAnswer.setUser(user);
        userAnswer.setQuestion(question);
        userAnswer.setSelectedOption(userAnswerDto.getSelectedOption());

        return userAnswerRepository.save(userAnswer);
    }


    @GetMapping("/{id}")
    public UserAnswers getUserAnswerById(@PathVariable Long id) {
        return userAnswerService.getUserAnswerById(id);
    }

    @PutMapping("/{id}")
    public UserAnswers updateUserAnswer(@PathVariable Long id, @RequestBody UserAnswers userAnswer) {
        return userAnswerService.updateUserAnswer(id, userAnswer);
    }

    @DeleteMapping("/{id}")
    public void deleteUserAnswer(@PathVariable Long id) {
        userAnswerService.deleteUserAnswer(id);
    }

    @GetMapping
    public List<UserAnswers> getAllUserAnswers() {
        return userAnswerService.getAllUserAnswers();
    }
}

