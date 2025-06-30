package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, java.util.UUID> {
    List<Question> findByCategory(String category);
}

