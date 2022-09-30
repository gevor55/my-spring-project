package com.myspringproject.mapper.cafe;


import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.model.Cafe;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CafeMapper {

    public Cafe dtoToEntity(CafeRequestDto dto) {
        Cafe cafe = new Cafe();
        cafe.setName(dto.getName());
        cafe.setAddress(dto.getAddress());

        return cafe;
    }

    public CafeResponseDto entityToDto(Cafe cafe) {
        CafeResponseDto dto = new CafeResponseDto();
        dto.setName(cafe.getName());
        dto.setAddress(cafe.getAddress());

        return dto;
    }
}
