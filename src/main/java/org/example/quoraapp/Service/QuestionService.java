package org.example.quoraapp.Service;

import org.example.quoraapp.DTO.QuestionResponseDTO;
import org.example.quoraapp.DTO.QuestionsReqDto;
import org.example.quoraapp.Mapper.QuestionMapper;
import org.example.quoraapp.Models.Question;
import org.example.quoraapp.Repository.QuestionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class QuestionService implements IQuestionService{

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionsReqDto questionsReqDto) {
        Question question = Question.builder()
                .title(questionsReqDto.getTitle())
                .content(questionsReqDto.getContent())
                .build();

        return questionRepository.save(question) // saves the question int the mongo db and gives mono of question
                .map(QuestionMapper::toQuestionResponseDTO)
                .doOnSuccess(response-> System.out.println("Question created successfully"+response))
                .doOnError(error -> System.out.println("Question creation failed"+error.getMessage()));
    }
}
