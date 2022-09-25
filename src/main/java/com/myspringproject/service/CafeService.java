package com.myspringproject.service;

import com.myspringproject.dto.CafeRequestDto;
import com.myspringproject.dto.CafeResponseDto;

import java.util.List;

public interface CafeService {

    List<CafeResponseDto> findAll();

    CafeResponseDto findById(Long id);

    CafeResponseDto create(CafeRequestDto dto);

    CafeResponseDto updateByName(String name, CafeRequestDto dto);

    void deleteById(Long id);
}
