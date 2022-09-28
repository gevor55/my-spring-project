package com.myspringproject.service.cafe;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;

import java.util.List;

public interface CafeService {

    List<CafeResponseDto> findAll();

    CafeResponseDto findById(Long id);

    CafeResponseDto create(CafeRequestDto dto);

    CafeResponseDto updateByName(String name, CafeRequestDto dto);

    void deleteById(Long id);
}
