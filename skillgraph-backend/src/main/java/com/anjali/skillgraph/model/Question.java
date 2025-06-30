package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String category; // e.g. "dsa", "cs-fundamentals", "user-added"
    private String title;
    private String description;

    // Getters, Setters, Constructors
}

