package com.anjali.skillgraph.service;

import com.anjali.skillgraph.model.UserProgress;
import com.anjali.skillgraph.repository.UserProgressRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProgressService {
    private final UserProgressRepository userProgressRepository;

    public UserProgressService(UserProgressRepository userProgressRepository) {
        this.userProgressRepository = userProgressRepository;
    }

    public UserProgress getProgress(Long userId, String category) {
        return userProgressRepository.findByUserIdAndCategory(userId, category)
                .orElse(new UserProgress());
    }

    public UserProgress saveProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }
}

