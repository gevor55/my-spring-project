package com.myspringproject.dto.user;

import com.myspringproject.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateCommand {

    @NotEmpty(message = "Mandatory field")
    private String username;

    @NotEmpty(message = "Mandatory field")
    private String firstName;

    @NotEmpty(message = "Mandatory field")
    private String lastName;

    @NotNull(message = "Mandatory field")
    private Collection<Role> role;
}
