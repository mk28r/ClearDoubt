package org.example.quoraapp.DTO;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LikeResponseDTO {
    private String id ;
    private String targetId ;
    private String targetType ;
    private Boolean isLike ;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
}



