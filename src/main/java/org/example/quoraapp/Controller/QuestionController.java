package org.example.quoraapp.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quoraapp.DTO.QuestionResponseDTO;
import org.example.quoraapp.DTO.QuestionsReqDto;
import org.example.quoraapp.Service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<QuestionResponseDTO> save(@Valid @RequestBody QuestionsReqDto questionsReqDto) {
        return questionService.createQuestion(questionsReqDto)
                .doOnSuccess(res-> System.out.println("Question created Sucessfully"+res))
                .doOnError(error-> System.out.println("Error creating questions"+error));
    }
}