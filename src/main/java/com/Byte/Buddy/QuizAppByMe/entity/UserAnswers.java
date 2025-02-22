package com.Byte.Buddy.QuizAppByMe.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_answers")
public class UserAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

    @Column(name = "selected_option", nullable = false)
    private Integer selectedOption;


    public UserAnswers(User user, Questions question, Integer selectedOption) {
    }
}

