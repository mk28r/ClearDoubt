package org.example.quoraapp.Service;


import org.example.quoraapp.DTO.QuestionResponseDTO;
import org.example.quoraapp.DTO.QuestionsReqDto;
import org.example.quoraapp.Models.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {
    public Mono<QuestionResponseDTO> createQuestion(QuestionsReqDto questionsReqDto);
    Flux<QuestionResponseDTO> searchQuestions(String searchTerm , int offset, int page );

    Flux<QuestionResponseDTO> getAllQuestions(String cursor, int size);
}
