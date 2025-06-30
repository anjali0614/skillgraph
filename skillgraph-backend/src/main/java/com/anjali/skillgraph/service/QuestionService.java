package com.anjali.skillgraph.service;

import com.anjali.skillgraph.model.Question;
import com.anjali.skillgraph.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }
}

