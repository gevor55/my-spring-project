package com.myspringproject.dto.cafe;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CafeResponseDto {
    private String name;
    private String address;
}
