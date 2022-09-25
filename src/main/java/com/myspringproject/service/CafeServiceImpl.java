package com.myspringproject.service;

import com.myspringproject.advice.NoSuchDataException;
import com.myspringproject.dto.CafeRequestDto;
import com.myspringproject.dto.CafeResponseDto;
import com.myspringproject.mapper.CafeMapper;
import com.myspringproject.model.Cafe;
import com.myspringproject.repository.CafeRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;

    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }


    @Override
    public List<CafeResponseDto> findAll() {
        List<Cafe> cafes = cafeRepository.findAll();
        List<CafeResponseDto> cafeResponseDtos = new ArrayList<>();
        for (Cafe cafe : cafes) {
            cafeResponseDtos.add(CafeMapper.toResponse(cafe));
        }
        return cafeResponseDtos;
    }

    @Override
    public CafeResponseDto findById(Long id) {
        Cafe cafe = cafeRepository.findById(id).orElseThrow(null);
        return CafeMapper.toResponse(cafe);
    }

    @Override
    public CafeResponseDto create(CafeRequestDto dto) {
        Cafe cafe = CafeMapper.toEntity(dto);
        cafeRepository.save(cafe);
        return CafeMapper.toResponse(cafe);
    }

    @Override
    public CafeResponseDto updateByName(String name, CafeRequestDto dto) {
        Cafe cafe = cafeRepository.findByName(name);
        if (cafe == null) {
            throw new NotFoundException("no");
        }
        cafe.setName(dto.getName());
        cafe.setAddress(dto.getAddress());
        cafeRepository.save(cafe);
        return CafeMapper.toResponse(cafe);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Cafe> cafe = cafeRepository.findById(id);
        if (cafe.isEmpty()) {
            throw new NoSuchDataException("Not found " + id);
        }
        cafeRepository.deleteById(id);
    }
}
