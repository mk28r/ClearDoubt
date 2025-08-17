package org.example.quoraapp.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.quoraapp.DTO.QuestionResponseDTO;
import org.example.quoraapp.DTO.QuestionsReqDto;
import org.example.quoraapp.Service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<QuestionResponseDTO> createQuestion(@Valid @RequestBody QuestionsReqDto questionsReqDto) {
        return questionService.createQuestion(questionsReqDto)
                .doOnSuccess(res -> log.info("Question created successfully: {}", res))
                .doOnError(err -> log.error("Error creating question", err));
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDTO> getQuestionById(@PathVariable String id) {
        throw new UnsupportedOperationException("Not Implemented Error");
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteQuestion(@PathVariable String id) {
        throw new UnsupportedOperationException("Not Implemented Error");

    }

    // Search with pagination
    @GetMapping("/search")
    public Flux<QuestionResponseDTO> searchQuestions(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return questionService.searchQuestions(query, page, size);
    }

    // Search with tag
    @GetMapping("/tag/{tag}")
    public Flux<QuestionResponseDTO> getQuestionByTag(
            @PathVariable String tag,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        throw new UnsupportedOperationException("Not Implemented Error");

    }

    @GetMapping()
    public Flux<QuestionResponseDTO> getAllQuestions(
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") int size
    ) {
        return questionService.getAllQuestions(cursor, size)
                .doOnError(error -> System.out.println("Error fetching questions: " + error))
                .doOnComplete(() -> System.out.println("Questions fetched successfully"));
    }
}












