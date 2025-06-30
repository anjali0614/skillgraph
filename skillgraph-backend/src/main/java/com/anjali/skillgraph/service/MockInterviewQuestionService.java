package com.anjali.skillgraph.service;

import com.anjali.skillgraph.model.MockInterviewQuestion;
import com.anjali.skillgraph.repository.MockInterviewQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockInterviewQuestionService {

    private final MockInterviewQuestionRepository mockInterviewQuestionRepository;

    public MockInterviewQuestionService(MockInterviewQuestionRepository mockInterviewQuestionRepository) {
        this.mockInterviewQuestionRepository = mockInterviewQuestionRepository;
    }

    public List<MockInterviewQuestion> getAllQuestions() {
        return mockInterviewQuestionRepository.findAll();
    }

    public MockInterviewQuestion addQuestion(MockInterviewQuestion question) {
        return mockInterviewQuestionRepository.save(question);
    }
}


