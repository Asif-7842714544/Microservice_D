package com.example.QuizService.Services;

import com.example.QuizService.Entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz add(Quiz quiz);

    List<Quiz> get();

    Quiz getById(int id);

}
