package com.example.QuizService.Controller;

import com.example.QuizService.Entity.Quiz;
import com.example.QuizService.Services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    //create
    @PostMapping
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.add(quiz);
    }

    //get all
    @GetMapping
    public List<Quiz> getall(){
        return quizService.get();
    }

    //get by id
    @GetMapping("/{id}")
    public Quiz getById(@PathVariable int id){
        return quizService.getById(id);
    }

}
