package com.Byte.Buddy.QuizAppByMe.repository;


import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {
}
