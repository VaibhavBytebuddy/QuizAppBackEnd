package com.Byte.Buddy.QuizAppByMe.repository;

import com.Byte.Buddy.QuizAppByMe.entity.UserAnswers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswers ,Long> {

    List<UserAnswers> findByUserId(Long userId);
    List<UserAnswers> findByQuestionId(Long questionId);
}
