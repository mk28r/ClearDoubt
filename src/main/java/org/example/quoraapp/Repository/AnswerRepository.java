package org.example.quoraapp.Repository;


import org.example.quoraapp.Models.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends ReactiveMongoRepository<Answer, String> {

}
