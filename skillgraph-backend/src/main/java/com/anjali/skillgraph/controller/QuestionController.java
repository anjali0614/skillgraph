package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.dto.UserQuestionsDTO;
import com.anjali.skillgraph.service.UserQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin
public class QuestionController {

    private final UserQuestionsService userQuestionService;

    @Autowired
    public QuestionController(UserQuestionsService userQuestionService) {
        this.userQuestionService = userQuestionService;
    }

    @GetMapping("/user/{userId}")
    public List<UserQuestionsDTO> getAllQuestions(@PathVariable Long userId) {
        return userQuestionService.getAllQuestionsByUser(userId);
    }

    @PostMapping
    public UserQuestionsDTO addQuestion(@RequestBody UserQuestionsDTO dto) {
        return userQuestionService.addQuestion(dto);
    }
}


