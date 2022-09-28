package com.myspringproject.mapper;


import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.model.Cafe;

public class CafeMapper {

    public static Cafe toEntity(CafeRequestDto dto) {
        Cafe cafe = new Cafe();
        cafe.setName(dto.getName());
        cafe.setAddress(dto.getAddress());

        return cafe;
    }

    public static CafeResponseDto toResponse(Cafe cafe) {
        CafeResponseDto dto = new CafeResponseDto();
        dto.setName(cafe.getName());
        dto.setAddress(cafe.getAddress());

        return dto;
    }
}
