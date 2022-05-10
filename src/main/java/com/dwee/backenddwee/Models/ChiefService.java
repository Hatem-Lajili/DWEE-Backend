package com.dwee.backenddwee.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "chiefservices")
public class ChiefService {

    @Id
    private String id;

    @NotBlank
    @Size(max = 30)
    @Field("firstname")
    private String firstname;

    @NotBlank
    @Size(max = 30)
    @Field("lastname")
    private String lastname;

    @DBRef
    private List<Doctor> doctors;

    @NotBlank
    @Email
    @Size(max = 50)
    @Field("email")
    private String email;

    @NotBlank
    @Digits(fraction = 0, integer = 10)
    @Field("phonenumber")
    private String phoneNumber;

    @NotBlank
    @Field("gender")
    private Gender gender;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

}
