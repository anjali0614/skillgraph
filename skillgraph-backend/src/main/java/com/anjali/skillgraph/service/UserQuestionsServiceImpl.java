package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.UserQuestionsDTO;
import com.anjali.skillgraph.model.User;
import com.anjali.skillgraph.model.UserQuestions;
import com.anjali.skillgraph.repository.UserQuestionsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserQuestionsServiceImpl implements UserQuestionsService {

    private final UserQuestionsRepository repository;

    public UserQuestionsServiceImpl(UserQuestionsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserQuestionsDTO> getAllQuestionsByUser(Long userId) {
        List<UserQuestions> questions = repository.findByUserId(userId);
        List<UserQuestionsDTO> dtos = new ArrayList<>();

        for (UserQuestions q : questions) {
            dtos.add(UserQuestionsDTO.builder()
                    .id(q.getId())
                    .userId(q.getUser().getId())
                    .question(q.getQuestion())
                    .category(q.getCategory())
                    .solved(q.isSolved())
                    .build());
        }
        return dtos;
    }

    @Override
    public UserQuestionsDTO addQuestion(UserQuestionsDTO dto) {
        UserQuestions question = new UserQuestions();
        User user = new User();
        user.setId(dto.getUserId());
        question.setUser(user);

        question.setQuestion(dto.getQuestion());
        question.setCategory(dto.getCategory());
        question.setSolved(dto.isSolved());

        UserQuestions saved = repository.save(question);

        return UserQuestionsDTO.builder()
                .id(saved.getId())
                .userId(saved.getUser().getId())
                .question(saved.getQuestion())
                .category(saved.getCategory())
                .solved(saved.isSolved())
                .build();
    }
}





