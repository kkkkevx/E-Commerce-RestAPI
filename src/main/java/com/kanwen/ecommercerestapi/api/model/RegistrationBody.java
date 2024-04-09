package com.kanwen.ecommercerestapi.api.model;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationBody {
    @NotNull
    @NotBlank
    @Size(min = 3)
    @Size(max = 255)
    private String username;
    @NotNull
    @NotBlank
    @Size(min = 6)
    @Size(max = 32)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    private String password;
    @Email
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
}
