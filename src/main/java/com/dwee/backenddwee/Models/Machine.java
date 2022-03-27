package com.dwee.backenddwee.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Machine")
public class Machine {
    @Id
    private String id;

    @Field(name = "flow")
    private double flow;

    @Field(name = "temperature")
    private double temperature;

    @Field(name = "fio2")
    private double fio2;

    @Field(name = "spo2")
    private double spo2;
}
