package com.anjali.skillgraph.service;

import com.anjali.skillgraph.dto.FundamentalTopicsDTO;
import com.anjali.skillgraph.model.FundamentalTopics;
import com.anjali.skillgraph.model.User;
import com.anjali.skillgraph.repository.FundamentalTopicsRepository;
import com.anjali.skillgraph.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FundamentalTopicsService {

    @Autowired
    private FundamentalTopicsRepository repository;

    @Autowired
    private UserRepository userRepository;

    public FundamentalTopicsDTO createTopic(FundamentalTopicsDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FundamentalTopics topic = FundamentalTopics.builder()
                .topicName(dto.getTopicName())
                .category(dto.getCategory())
                .isCompleted(dto.isCompleted())
                .user(user)
                .build();

        FundamentalTopics saved = repository.save(topic);

        return FundamentalTopicsDTO.builder()
                .id(saved.getId())
                .topicName(saved.getTopicName())
                .category(saved.getCategory())
                .completed(saved.isCompleted())
                .userId(saved.getUser().getId())
                .build();
    }

    public List<FundamentalTopicsDTO> getAllTopics() {
        return repository.findAll().stream().map(topic -> FundamentalTopicsDTO.builder()
                .id(topic.getId())
                .topicName(topic.getTopicName())
                .category(topic.getCategory())
                .completed(topic.isCompleted())
                .userId(topic.getUser().getId())
                .build()
        ).collect(Collectors.toList());
    }

    public List<FundamentalTopicsDTO> getTopicsByUserId(Long userId) {
        List<FundamentalTopics> topics = repository.findByUserId(userId);
        return topics.stream()
                .map(topic -> FundamentalTopicsDTO.builder()
                        .id(topic.getId())
                        .topicName(topic.getTopicName())
                        .category(topic.getCategory())
                        .completed(topic.isCompleted())
                        .userId(topic.getUser().getId())
                        .build())
                .collect(Collectors.toList());
    }

}



