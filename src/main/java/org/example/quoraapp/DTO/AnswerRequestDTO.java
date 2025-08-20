package org.example.quoraapp.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AnswerRequestDTO {
    @NotBlank(message = "Content is blank")
    @Size(min = 10 , max = 100 , message = "Content must be between 10 to 100")
    private String content ;

    @NotBlank(message = "Question Id is blank")
    private String questionId ;
}
