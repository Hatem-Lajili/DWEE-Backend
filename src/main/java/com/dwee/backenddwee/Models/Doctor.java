package com.dwee.backenddwee.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Doctor")
public class Doctor  {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;


}
