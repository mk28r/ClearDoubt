package org.example.quoraapp.Models;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "Like")
public class Like extends Base{

    private String targetId ; // will store the id of which {target type} we are liking

    private String targetType ; // Question , Answer , comments etc

    


}
