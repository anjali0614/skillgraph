package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_mock_attempts")
public class UserMockAttempt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String category;
    private String questionsAttempted;
    private int score;
    private long timeTaken;

    public UserMockAttempt() {
    }

    public UserMockAttempt(Long id, Long userId, String category, String questionsAttempted, int score, long timeTaken) {
        this.id = id;
        this.userId = userId;
        this.category = category;
        this.questionsAttempted = questionsAttempted;
        this.score = score;
        this.timeTaken = timeTaken;
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

    public String getQuestionsAttempted() {
        return questionsAttempted;
    }

    public void setQuestionsAttempted(String questionsAttempted) {
        this.questionsAttempted = questionsAttempted;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }
}

