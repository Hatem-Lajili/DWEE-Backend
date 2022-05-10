package com.dwee.backenddwee.Models.request;

import com.dwee.backenddwee.Models.Gender;

import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class DoctorRequest {

    @NotBlank
    @Size(max = 30)
    @Field("firstname")
    private String firstname;

    @NotBlank
    @Size(max = 30)
    @Field("lastname")
    private String lastname;

    @NotBlank
    @Email
    @Size(max = 50)
    @Field("email")
    private String email;

    @NotBlank
    @Digits(fraction = 0, integer = 10)
    @Field("phonenumber")
    private String phonenumber;

    @NotBlank
    private Gender gender;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private String chiefServiceId;

}


