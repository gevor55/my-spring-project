package com.myspringproject.service.cafe;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;

import java.util.List;
import java.util.Optional;

public interface CafeService {

    List<CafeResponseDto> findAll();

    Optional<CafeResponseDto> findById(Long id);

    CafeResponseDto create(CafeRequestDto dto);

    CafeResponseDto updateByName(String name, CafeRequestDto dto);

    void deleteById(Long id);

    List<CafeResponseDto> search(String name, String address);
}
