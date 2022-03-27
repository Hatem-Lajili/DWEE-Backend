package com.dwee.backenddwee.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Hospital")
public class Hospital {
    @Id
    private String id;

    @Field("name_hospital")
    private String name_hospital;

    @DBRef
    private List<Department> departments;
}
