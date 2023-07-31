package com.myspringproject.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchCommand {
    private String username;
    private String firstName;
    private String lastName;
    private UserStatus status;
    private Role role;

}
