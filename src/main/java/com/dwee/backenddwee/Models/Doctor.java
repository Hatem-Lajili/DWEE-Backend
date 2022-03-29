package com.dwee.backenddwee.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data


@Document(collection = "Doctor")
public class Doctor extends User  {

   /* public Doctor() {

    }
    public Doctor(List<Machine> machines) {
        this.machines = machines;
    }


    private List<Machine> machines;*/


}
