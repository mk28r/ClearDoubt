package org.example.quoraapp.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.example.quoraapp.Models.Base;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LikeRequestDTO {

    @NotBlank(message = "Target Id is required")
    private String targetId ; // will store the id of which {target type} we are liking

    @NotBlank(message = "Target Type is required")
    private String targetType ; // Question , Answer , comments etc

    @NotNull(message = "Is like is required")
    private Boolean isLike ;

}



