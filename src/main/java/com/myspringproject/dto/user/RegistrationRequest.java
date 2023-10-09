package com.myspringproject.dto.user;

import com.myspringproject.constants.PatternConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @Pattern(regexp = PatternConstants.PASSWORD_PATTERN,
            message = "New password must be at least 8 characters long and contain at least one letter and one digit")
    private String password;

    @NotNull(message = "Mandatory field")
    @Pattern(regexp = PatternConstants.PASSWORD_PATTERN,
            message = "New password must be at least 8 characters long and contain at least one letter and one digit")
    private String confirmPassword;

}