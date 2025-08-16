package org.example.quoraapp.Models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collation = "questions")

public class Question extends Base{

    @NotBlank(message = "Title is blank")
    @Size(min = 10 , max = 100 , message = "Title must be between 10 to 100")
    private String title ;

    @NotBlank(message = "Title is blank")
    @Size(min = 10 , max = 100 , message = "Title must be between 10 to 100")
    private String content ;

    private String authorId ;


}
