package com.myspringproject.dto.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchRequest {
    private String username;
    private String firstName;
    private String lastName;
    private UserStatus status;

}
