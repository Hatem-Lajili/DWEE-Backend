package com.dwee.backenddwee.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


@Data
@Getter
@Setter

@Document(collection = "ChfS")
public class ChfS extends User {

    public ChfS() {

    }
    public ChfS(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @DBRef
    private List<Doctor> doctors  ;


}
