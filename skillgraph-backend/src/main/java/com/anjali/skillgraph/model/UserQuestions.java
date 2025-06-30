package com.anjali.skillgraph.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_questions")
public class UserQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String question;
    private String category;
    private boolean solved;

    public UserQuestions() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public boolean isSolved() { return solved; }
    public void setSolved(boolean solved) { this.solved = solved; }
}




