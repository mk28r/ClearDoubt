package org.example.quoraapp.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class QuestionsReqDto {
    @NotBlank(message = "Title is blank")
    @Size(min = 10 , max = 100 , message = "Title must be between 10 to 100")
    private String title ;

    @NotBlank(message = "Title is blank")
    @Size(min = 10 , max = 100 , message = "Title must be between 10 to 100")
    private String content ;
}
