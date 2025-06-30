package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MockInterviewQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String topic; // DSA, HR, CS Fundamentals, etc.

    private String difficulty; // Easy, Medium, Hard

    private String type; // Random, User-uploaded, etc.

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

