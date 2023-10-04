package com.myspringproject.dto.user;

import com.myspringproject.constants.PatternConstants;
import com.myspringproject.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationCommand {

    @NotEmpty(message = "Mandatory field")
    private String username;

    @NotEmpty(message = "Mandatory field")
    private String firstName;

    @NotEmpty(message = "Mandatory field")
    private String lastName;

    @NotNull(message = "Mandatory field")
    private LocalDate birthDate;

    @NotNull(message = "Mandatory field")
    private UserStatus userStatus;

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

    @NotNull(message = "Mandatory field")
    private Collection<Role> roles;


}