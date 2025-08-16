package org.example.quoraapp.Mapper;

import org.example.quoraapp.DTO.QuestionResponseDTO;
import org.example.quoraapp.Models.Question;

public class QuestionMapper {
    public static QuestionResponseDTO toQuestionResponseDTO(Question question) {
        return QuestionResponseDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .build();
    }
}
