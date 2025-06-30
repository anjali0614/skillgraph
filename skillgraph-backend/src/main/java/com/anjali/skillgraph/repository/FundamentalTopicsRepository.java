package com.anjali.skillgraph.repository;

import com.anjali.skillgraph.model.FundamentalTopics;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FundamentalTopicsRepository extends JpaRepository<FundamentalTopics, Long> {
    List<FundamentalTopics> findByUserId(Long userId);
}


