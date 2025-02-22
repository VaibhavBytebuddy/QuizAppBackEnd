package com.Byte.Buddy.QuizAppByMe.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserAnswerDTO {

    private Long id;
    private Long userId;
    private Long questionId;
    private Integer selectedOption;


    public UserAnswerDTO(Long id, Long id1, Integer selectedOption) {
    }
}
