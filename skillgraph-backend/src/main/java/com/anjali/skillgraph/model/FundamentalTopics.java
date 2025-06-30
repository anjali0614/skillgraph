package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundamentalTopics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topicName;

    private String category; // OS, DBMS, CN, etc.

    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

