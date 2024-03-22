package com.example.QuestionService.Service;

import com.example.QuestionService.Entities.Question;

import java.util.List;

public interface QuestionService {

    Question create (Question question);

    List<Question> get();

    Question getById(int id);

    List<Question> getQuestionByQuiz(int quizId);

}
