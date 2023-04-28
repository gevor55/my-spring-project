package com.myspringproject.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotEmpty(message = "Mandatory field")
    private String username;

    @NotEmpty(message = "Mandatory field")
    private String firstName;

    @NotEmpty(message = "Mandatory field")
    private String lastName;

    @NotNull(message = "Mandatory field")
    private LocalDateTime birthDate;
}