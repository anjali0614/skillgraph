package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProgressRepository extends JpaRepository<UserProgress, java.util.UUID> {
    Optional<UserProgress> findByUserIdAndCategory(Long userId, String category);
}

