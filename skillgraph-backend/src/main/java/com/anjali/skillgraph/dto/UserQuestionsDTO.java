package com.anjali.skillgraph.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserQuestionsDTO {
    private Long id;
    private Long userId;
    private String question;
    private String category;
    private boolean solved;
}



