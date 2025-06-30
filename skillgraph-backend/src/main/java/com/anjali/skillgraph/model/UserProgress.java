package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_progress")
public class UserProgress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String category;
    private int totalQuestions;
    private int solvedQuestions;

    public UserProgress() {
    }

    public UserProgress(Long id, Long userId, String category, int totalQuestions, int solvedQuestions) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.totalQuestions = totalQuestions;
        this.solvedQuestions = solvedQuestions;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getSolvedQuestions() {
        return solvedQuestions;
    }

    public void setSolvedQuestions(int solvedQuestions) {
        this.solvedQuestions = solvedQuestions;
    }
}


