package org.example.quoraapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class QuestionResponseDTO {
    private String id ;
    private String title ;
    private String content;
}
