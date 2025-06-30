package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MockSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime sessionDate;

    private int totalQuestions;

    private int correctAnswers;

    private int timeTakenMinutes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<MockInterviewQuestion> questionsUsed;
}
