package com.anjali.skillgraph.controller;

import com.anjali.skillgraph.model.MockSession;
import com.anjali.skillgraph.service.MockSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mock-sessions")
@CrossOrigin(origins = "*")
public class MockSessionController {

    @Autowired
    private MockSessionService service;

    @GetMapping("/{userId}")
    public List<MockSession> getByUser(@PathVariable Long userId) {
        return service.getSessionsByUserId(userId);
    }

    @PostMapping
    public MockSession add(@RequestBody MockSession session) {
        return service.addSession(session);
    }
}

