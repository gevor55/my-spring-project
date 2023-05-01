package com.myspringproject.dto.cafe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CafeResponseDto {
    private String name;
    private String address;
}
