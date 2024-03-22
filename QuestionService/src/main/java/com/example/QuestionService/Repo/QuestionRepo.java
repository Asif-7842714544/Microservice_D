package com.example.QuestionService.Repo;


import com.example.QuestionService.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Integer> {

    List<Question> findByQuizId(int quidId);

}
