package com.Byte.Buddy.QuizAppByMe.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quiz_questions")
@Data
@NoArgsConstructor

@AllArgsConstructor
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "question_id",nullable = false)
    private Questions question;


}
