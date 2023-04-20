package com.myspringproject.dto.cafe;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class CafeRequestDto {

    @NotEmpty(message = "Mandatory field")
    private String name;

    @NotEmpty(message = "Mandatory field")
    private String address;
}
