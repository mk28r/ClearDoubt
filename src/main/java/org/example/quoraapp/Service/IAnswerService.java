package org.example.quoraapp.Service;

import org.example.quoraapp.DTO.AnswerResponseDTo;
import reactor.core.publisher.Mono;

public interface IAnswerService {
    public Mono<AnswerResponseDTo> getAnswerById(Long id);
    public Mono<AnswerResponseDTo> createAnswer(AnswerResponseDTo answerResponseDTo);

}
