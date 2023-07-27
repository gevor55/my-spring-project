package com.myspringproject.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserResponseDto {

    private String username;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private UserStatus userStatus;

    private Role role;
}
