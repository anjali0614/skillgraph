package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.MockInterviewQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MockInterviewQuestionRepository extends JpaRepository<MockInterviewQuestion, Long> {
    List<MockInterviewQuestion> findByTopic(String category);
}

