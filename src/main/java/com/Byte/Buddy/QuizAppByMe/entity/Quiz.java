package com.Byte.Buddy.QuizAppByMe.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "quizzes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String quizName;

    @Column(nullable = false)
    private String technology;

    @JsonIgnoreProperties("quiz")
    @OneToMany(mappedBy = "quiz" ,cascade = CascadeType.ALL)
    private List<QuizQuestion> quizQuestions;
}
