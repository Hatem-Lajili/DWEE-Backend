package com.dwee.backenddwee.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="AbstractEntity" )
public class AbstractEntity {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
}
