package com.dwee.backenddwee.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "devices")
public class Device {
    @Id
    private String id;

    private String idDevice;

    @Field(name = "flow")
    private double flow;

    @Field(name = "temperature")
    private double temperature;

    @Field(name = "fio2")
    private double fio2;

    @Field(name = "spo2")
    private double spo2;

    @Field(name = "connected")
    private boolean isConnected;

    @Field(name = "lastrefreshed")
    private Date lastRefreshed;

    @Field(name = "workingproperly")
    private boolean isWorkingProperly;

    @Field(name = "errormessage")
    private String errorMessage;

}
