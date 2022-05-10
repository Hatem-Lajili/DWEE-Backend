package com.dwee.backenddwee.Models.request;

import com.dwee.backenddwee.Models.ERole;
import com.dwee.backenddwee.Models.Role;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignupRequest {

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private ERole role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
