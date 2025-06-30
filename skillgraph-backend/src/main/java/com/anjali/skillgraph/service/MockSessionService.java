package com.anjali.skillgraph.service;

import com.anjali.skillgraph.model.MockSession;
import com.anjali.skillgraph.repository.MockSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockSessionService {

    private final MockSessionRepository mockSessionRepository;

    public MockSessionService(MockSessionRepository mockSessionRepository) {
        this.mockSessionRepository = mockSessionRepository;
    }

    public List<MockSession> getSessionsByUserId(Long userId) {
        return mockSessionRepository.findByUserId(userId);
    }

    public MockSession addSession(MockSession session) {
        return mockSessionRepository.save(session);
    }
}


