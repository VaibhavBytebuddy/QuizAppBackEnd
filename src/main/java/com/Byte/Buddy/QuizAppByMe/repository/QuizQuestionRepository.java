package com.Byte.Buddy.QuizAppByMe.repository;

import com.Byte.Buddy.QuizAppByMe.entity.Quiz;
import com.Byte.Buddy.QuizAppByMe.entity.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion,Long> {
    List<QuizQuestion> findByQuiz(Quiz quizById);
}
