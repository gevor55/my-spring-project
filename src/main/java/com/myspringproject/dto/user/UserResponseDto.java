package com.myspringproject.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.myspringproject.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private String username;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    private UserStatus userStatus;

    private Collection<Role> role;

    private String email;
}
