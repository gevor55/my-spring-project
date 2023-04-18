package com.myspringproject.dto.cafe;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CafeRequestDto {

    @NotEmpty(message = "Mandatory field")
    private String name;

    @NotEmpty(message = "Mandatory field")
    private String address;
}
