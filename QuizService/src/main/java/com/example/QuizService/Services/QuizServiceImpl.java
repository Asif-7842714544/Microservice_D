package com.example.QuizService.Services;

import com.example.QuizService.Entity.Quiz;
import com.example.QuizService.Repo.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepo quizRepo;

    private final QuestionClient questionClient;

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        List<Quiz> quizzes = quizRepo.findAll();
        List<Quiz> quizList = quizzes.stream().map(quiz -> {
            quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
            return quiz;
        }).collect(Collectors.toList());
        return quizList;
    }

    @Override
    public Quiz getById(int id) {
        Quiz quiz = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("quiz not found with id " + id));

        quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getId()));
        return quiz;
    }
}
