package com.myspringproject.dto.cafe;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@Validated
public class CafeRequestDto {

    @NotEmpty(message = "Mandatory field")
    private String name;

    @NotEmpty(message = "Mandatory field")
    private String address;
}
