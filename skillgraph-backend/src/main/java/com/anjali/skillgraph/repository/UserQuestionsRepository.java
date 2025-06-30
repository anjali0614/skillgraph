package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.UserQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestionsRepository extends JpaRepository<UserQuestions, Long> {
    List<UserQuestions> findByUserId(Long userId);
}

