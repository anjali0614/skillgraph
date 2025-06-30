package com.anjali.skillgraph.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FundamentalTopicsDTO {
    private Long id;
    private String topicName;
    private String category;
    private boolean completed;
    private Long userId;
}

