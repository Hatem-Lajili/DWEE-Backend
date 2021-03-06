package com.dwee.backenddwee.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank
    @Email
    @Size(max = 50)
    @Field("email")
    private String email;

    @NotBlank
    @Size(max = 120)
    @Field("password")
    private String password;

    @NotBlank
    @Field
    private  boolean isVerified;

    @DBRef
    private Role role;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
