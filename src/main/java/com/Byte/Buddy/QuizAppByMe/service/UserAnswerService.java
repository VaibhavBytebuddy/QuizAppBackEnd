package com.Byte.Buddy.QuizAppByMe.service;

import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import com.Byte.Buddy.QuizAppByMe.entity.User;
import com.Byte.Buddy.QuizAppByMe.entity.UserAnswerDTO;
import com.Byte.Buddy.QuizAppByMe.entity.UserAnswers;
import com.Byte.Buddy.QuizAppByMe.repository.QuestionRepository;
import com.Byte.Buddy.QuizAppByMe.repository.UserAnswerRepository;
import com.Byte.Buddy.QuizAppByMe.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService {

    @Autowired
    private  UserAnswerRepository userAnswerRepository;



    public UserAnswers createUserAnswer(UserAnswers userAnswer) {
        // Perform any necessary validation or business logic
        // Save the userAnswer entity in the database
        return userAnswerRepository.save(userAnswer);
    }

    public UserAnswers getUserAnswerById(Long id) {
        return userAnswerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User Answer not found"));
    }

    public UserAnswers updateUserAnswer(Long id, UserAnswers updatedUserAnswer) {
        UserAnswers userAnswer = getUserAnswerById(id);
        // Perform any necessary validation or business logic
        // Update the userAnswer entity with the new values
        userAnswer.setUser(updatedUserAnswer.getUser());
        userAnswer.setQuestion(updatedUserAnswer.getQuestion());
        userAnswer.setSelectedOption(updatedUserAnswer.getSelectedOption());
        return userAnswerRepository.save(userAnswer);
    }

    public void deleteUserAnswer(Long id) {
        UserAnswers userAnswer = getUserAnswerById(id);
        // Perform any necessary validation or business logic
        userAnswerRepository.delete(userAnswer);
    }

    public List<UserAnswers> getAllUserAnswers() {
        return userAnswerRepository.findAll();
    }
}

