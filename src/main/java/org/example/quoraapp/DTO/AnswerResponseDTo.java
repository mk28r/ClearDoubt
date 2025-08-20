package org.example.quoraapp.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class AnswerResponseDTo {
   private String id ;
   private String content ;

   private LocalDateTime createdAt ;
   private LocalDateTime updatedAt ;

}
