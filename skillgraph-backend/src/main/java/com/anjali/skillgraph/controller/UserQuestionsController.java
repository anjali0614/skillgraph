package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.dto.UserQuestionsDTO;
import com.anjali.skillgraph.service.UserQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-questions")
@CrossOrigin
public class UserQuestionsController {

    @Autowired
    private UserQuestionsService service;

    @GetMapping("/{userId}")
    public List<UserQuestionsDTO> getUserQuestions(@PathVariable Long userId) {
        return service.getAllQuestionsByUser(userId);
    }

    @PostMapping
    public UserQuestionsDTO addQuestion(@RequestBody UserQuestionsDTO dto) {
        return service.addQuestion(dto);
    }
}

