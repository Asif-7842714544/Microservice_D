package com.example.QuestionService.Service;

import com.example.QuestionService.Entities.Question;
import com.example.QuestionService.Repo.QuestionRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServImpl implements QuestionService {

    private final QuestionRepo questionRepo;

    @Override
    public Question create(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepo.findAll();
    }

    @Override
    public Question getById(int id) {
        return questionRepo.findById(id).orElseThrow(() -> new RuntimeException("No such QuestionId: " + id));
    }

    @Override
    public List<Question> getQuestionByQuiz(int quizId) {
        return questionRepo.findByQuizId(quizId);
    }
}
