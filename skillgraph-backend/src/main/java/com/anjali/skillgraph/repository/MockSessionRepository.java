package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.MockSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MockSessionRepository extends JpaRepository<MockSession, Long> {
    List<MockSession> findByUserId(Long userId);
}


