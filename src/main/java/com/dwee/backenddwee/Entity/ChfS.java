package com.dwee.backenddwee.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ChfS")
public class ChfS {
    @Id
    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String photo;
    private List<Doctor> doctors;
}
