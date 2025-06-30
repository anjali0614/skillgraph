package com.anjali.skillgraph.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LearningResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    private String topic;

    private String type; // Video, Article, PDF

    private String platform; // YouTube, GeeksForGeeks, etc.
}

