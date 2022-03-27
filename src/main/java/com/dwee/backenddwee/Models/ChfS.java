package com.dwee.backenddwee.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;


@Data

@Document(collection = "ChfS")
public class ChfS {
    @Id
    private String id;
    private String name;

    @DBRef
    private Set<Doctor> doctors  ;

    public ChfS(String id, String name, Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.doctors = doctors;
    }
    public ChfS() {
        this.doctors = new HashSet<>();

    }
}
