package com.Byte.Buddy.QuizAppByMe.service;

import com.Byte.Buddy.QuizAppByMe.entity.Questions;
import com.Byte.Buddy.QuizAppByMe.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {



    @Autowired
    private QuestionRepository questionRepository;

    public Questions createQuestion(Questions question) {

        return questionRepository.save(question);
    }

    public Questions getQuestionById(Long id) {

        return questionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Question is not found "));
    }

    public Questions updateQuestion(Long id, Questions question)
    {
        Optional<Questions> questionsOptional=questionRepository.findById(id);
        if(questionsOptional.isPresent())
        {
            Questions updateQue=questionsOptional.get();
            updateQue.setId(question.getId());
            updateQue.setQuestionText(question.getQuestionText());
            updateQue.setOption1(question.getOption1());
            updateQue.setOption2(question.getOption2());
            updateQue.setOption3(question.getOption3());
            updateQue.setOption4(question.getOption4());
            updateQue.setCorrectOption(question.getCorrectOption());
            updateQue.setTechnology(question.getTechnology());

            questionRepository.save(updateQue);

        }

        return null;
    }

    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

    public List<Questions> getAllquestions() {
        return questionRepository.findAll();
    }
}
