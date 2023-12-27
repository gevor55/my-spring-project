package com.myspringproject.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginCommand {

    @NotNull(message = "Mandatory field")
    private String username;

    @NotNull(message = "Mandatory field")
    private String password;
}
