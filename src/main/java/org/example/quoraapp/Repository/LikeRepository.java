package org.example.quoraapp.Repository;

import org.example.quoraapp.Models.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends ReactiveMongoRepository<Like, String> {
}
