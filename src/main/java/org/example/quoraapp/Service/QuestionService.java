package org.example.quoraapp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.example.quoraapp.utils.CursorUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.example.quoraapp.DTO.QuestionResponseDTO;
import org.example.quoraapp.DTO.QuestionsReqDto;
import org.example.quoraapp.Mapper.QuestionMapper;
import org.example.quoraapp.Models.Question;
import org.example.quoraapp.Repository.QuestionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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


    @Override
    public Flux<QuestionResponseDTO> searchQuestions(String searchTerm, int offset, int page) {
        return questionRepository.findByTitleOrContentContainingIgnoreCase(searchTerm, PageRequest.of(offset, page))
                .map(QuestionMapper::toQuestionResponseDTO)
                .doOnError(error -> System.out.println("Error searching questions: " + error))
                .doOnComplete(() -> System.out.println("Questions searched successfully"));
    }

    @Override
    public Flux<QuestionResponseDTO> getAllQuestions(String cursor, int size) {
        Pageable pageable = PageRequest.of(0, size);

        if(!CursorUtils.isValidCursor(cursor)) {
            return questionRepository.findTop10ByOrderByCreatedAtAsc()
                    .take(size)
                    .map(QuestionMapper::toQuestionResponseDTO)
                    .doOnError(error -> System.out.println("Error fetching questions: " + error))
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"));
        } else {
            LocalDateTime cursorTimeStamp = CursorUtils.parseCursor(cursor);
            return questionRepository.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimeStamp, pageable)
                    .map(QuestionMapper::toQuestionResponseDTO)
                    .doOnError(error -> System.out.println("Error fetching questions: " + error))
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"));
        }

    }
}
