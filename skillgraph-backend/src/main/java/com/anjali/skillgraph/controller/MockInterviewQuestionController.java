package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.service.MockInterviewQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import com.anjali.skillgraph.model.MockInterviewQuestion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mock-questions")
@CrossOrigin(origins = "*")
public class MockInterviewQuestionController {

    @Autowired
    private MockInterviewQuestionService service;

    @GetMapping
    public List<MockInterviewQuestion> getAll() {
        return service.getAllQuestions();
    }

    @PostMapping
    public MockInterviewQuestion add(@RequestBody MockInterviewQuestion question) {
        return service.addQuestion(question);
    }
}

