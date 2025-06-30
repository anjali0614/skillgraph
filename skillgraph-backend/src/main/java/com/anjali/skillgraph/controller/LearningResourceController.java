package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.model.LearningResource;
import com.anjali.skillgraph.service.LearningResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
@CrossOrigin(origins = "*")
public class LearningResourceController {

    @Autowired
    private LearningResourceService service;

    @GetMapping
    public List<LearningResource> getAll() {
        return service.getAllResources();
    }

    @PostMapping
    public LearningResource add(@RequestBody LearningResource resource) {
        return service.addResource(resource);
    }
}

