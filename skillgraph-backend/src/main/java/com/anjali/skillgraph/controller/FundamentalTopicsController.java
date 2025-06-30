package com.anjali.skillgraph.controller;


import com.anjali.skillgraph.dto.FundamentalTopicsDTO;
import com.anjali.skillgraph.service.FundamentalTopicsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fundamentals")
public class FundamentalTopicsController {

    @Autowired
    private FundamentalTopicsService service;

    @PostMapping
    public ResponseEntity<FundamentalTopicsDTO> create(@RequestBody FundamentalTopicsDTO dto) {
        return ResponseEntity.ok(service.createTopic(dto));
    }

    @GetMapping
    public ResponseEntity<List<FundamentalTopicsDTO>> getAll() {
        return ResponseEntity.ok(service.getAllTopics());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FundamentalTopicsDTO>> getByUserId(@PathVariable Long userId) {
        List<FundamentalTopicsDTO> topics = service.getTopicsByUserId(userId);
        return ResponseEntity.ok(topics);
    }

}

