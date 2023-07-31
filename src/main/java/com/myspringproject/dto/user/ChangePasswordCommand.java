package com.myspringproject.dto.user;

import com.myspringproject.constants.PatternConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class ChangePasswordCommand {

    @NotNull(message = "Mandatory field")
    @Pattern(regexp = PatternConstants.PASSWORD_PATTERN,
            message = "New password must be at least 8 characters long and contain at least one letter and one digit")
    private String newPassword;
}
