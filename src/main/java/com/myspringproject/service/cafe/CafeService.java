package com.myspringproject.service.cafe;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;

import java.util.Collection;
import java.util.Optional;

public interface CafeService {

    Collection<CafeResponseDto> findAll();

    Optional<CafeResponseDto> findById(Long id);

    CafeResponseDto create(CafeRequestDto dto);

    CafeResponseDto updateByName(String name, CafeRequestDto dto);

    void deleteById(Long id);
}
