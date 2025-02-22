package com.Byte.Buddy.QuizAppByMe.repository;

import com.Byte.Buddy.QuizAppByMe.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
