package org.example.quoraapp.Repository;

import org.example.quoraapp.Models.Question;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
//    Flux<Question> findByAuthorId(String id);
//    Mono<Long> countByAuthorId(String id); // Long, not Integer
}
