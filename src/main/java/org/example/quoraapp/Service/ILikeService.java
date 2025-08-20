package org.example.quoraapp.Service;

import org.example.quoraapp.DTO.LikeRequestDTO;
import org.example.quoraapp.DTO.LikeResponseDTO;
import reactor.core.publisher.Mono;

public interface ILikeService {
    Mono<LikeResponseDTO> createLike(LikeRequestDTO likeRequestDTO);
    Mono<LikeResponseDTO> countLikesByTargetIdAndTargetType(String targetId, String targetType);
    Mono<LikeResponseDTO> countDisLikesByTargetIdAndTargetType(String targetId, String targetType);
    Mono<LikeResponseDTO> toggleLike(String targetId, String targetType, Boolean isLike);
}
