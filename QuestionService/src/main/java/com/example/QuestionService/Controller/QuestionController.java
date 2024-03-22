package com.example.QuestionService.Controller;

import com.example.QuestionService.Entities.Question;
import com.example.QuestionService.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    @GetMapping
    public List<Question> getAll(){
        return questionService.get();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable int id) {
        return questionService.getById(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionByQuizId(@PathVariable int quizId) {
        return questionService.getQuestionByQuiz(quizId);
    }

}
