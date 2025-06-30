package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.UserQuestionsDTO;
import java.util.List;

public interface UserQuestionsService {
    List<UserQuestionsDTO> getAllQuestionsByUser(Long userId);
    UserQuestionsDTO addQuestion(UserQuestionsDTO dto);
}


