package com.myspringproject.mapper;


import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.model.Cafe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CafeMapper {

    public Cafe toEntity(CafeRequestDto dto) {
        Cafe cafe = new Cafe();
        cafe.setName(dto.getName());
        cafe.setAddress(dto.getAddress());

        return cafe;
    }

    public CafeResponseDto toResponse(Cafe cafe) {
        CafeResponseDto dto = new CafeResponseDto();
        dto.setName(cafe.getName());
        dto.setAddress(cafe.getAddress());

        return dto;
    }
}
