package com.myspringproject.dto.cafe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeRequestDto {

    @NotEmpty(message = "Mandatory field")
    private String name;

    @NotEmpty(message = "Mandatory field")
    private String address;
}
