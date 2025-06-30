package com.anjali.skillgraph.service;

import com.anjali.skillgraph.model.LearningResource;
import com.anjali.skillgraph.repository.LearningResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningResourceService {

    private final LearningResourceRepository learningResourceRepository;

    public LearningResourceService(LearningResourceRepository learningResourceRepository) {
        this.learningResourceRepository = learningResourceRepository;
    }

    public List<LearningResource> getAllResources() {
        return learningResourceRepository.findAll();
    }

    public LearningResource addResource(LearningResource resource) {
        return learningResourceRepository.save(resource);
    }
}

