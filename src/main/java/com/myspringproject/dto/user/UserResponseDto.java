package com.myspringproject.dto.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDto {

    private String username;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    private UserStatus userStatus;
}
