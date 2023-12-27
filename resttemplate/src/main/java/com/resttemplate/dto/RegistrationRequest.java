package com.resttemplate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Mandatory field")
    private String username;

    @NotEmpty(message = "Mandatory field")
    private String firstName;

    @NotEmpty(message = "Mandatory field")
    private String lastName;

    @NotNull(message = "Mandatory field")
    private LocalDate birthDate;

    @NotEmpty(message = "Mandatory field")
    private String email;

    @NotNull(message = "Mandatory field")
    private String password;

    @NotNull(message = "Mandatory field")
    private String confirmPassword;

}