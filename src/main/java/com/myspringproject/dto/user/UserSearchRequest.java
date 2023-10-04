package com.myspringproject.dto.user;

import com.myspringproject.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchRequest {
    private String username;
    private String firstName;
    private String lastName;
    private UserStatus status;
    private Collection<Role> role;

}
