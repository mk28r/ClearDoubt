package org.example.quoraapp.Models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "answers")
public class Answer extends Base{

    @NotBlank(message = "Content is blank")
    @Size(min = 10 , max = 100 , message = "Content must be between 10 to 100")
    private String content ;

    @Indexed(name = "question_id")
    private String questionId ;

}
