package com.myspringproject.service.cafe.impl;

import com.myspringproject.advice.NoSuchDataException;
import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.mapper.CafeMapper;
import com.myspringproject.model.Cafe;
import com.myspringproject.repository.CafeRepository;
import com.myspringproject.service.cafe.CafeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;
    private final CafeMapper cafeMapper;

    public CafeServiceImpl(CafeRepository cafeRepository, CafeMapper cafeMapper) {
        this.cafeRepository = cafeRepository;
        this.cafeMapper = cafeMapper;
    }


    @Override
    public List<CafeResponseDto> findAll() {
        List<Cafe> cafes = cafeRepository.findAll();
        List<CafeResponseDto> cafeResponseDtos = new ArrayList<>();
        for (Cafe cafe : cafes) {
            cafeResponseDtos.add(cafeMapper.toResponse(cafe));
        }
        return cafeResponseDtos;
    }

    @Override
    public CafeResponseDto findById(Long id) {
        return cafeRepository.findById(id)
                .map(cafeMapper::toResponse)
                .orElseThrow(() -> new NoSuchDataException())
    }

    @Override
    public CafeResponseDto create(CafeRequestDto dto) {
        Cafe cafe = cafeMapper.toEntity(dto);
        cafeRepository.save(cafe);
        return cafeMapper.toResponse(cafe);
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
        log.trace("Starting delete cafe with id: {}.", id);
        Optional<Cafe> cafe = cafeRepository.findById(id);
        if (cafe.isEmpty()) {
            throw new NoSuchDataException("Not found " + id);
        }
        log.debug("Cafe with id: {} successfully deleted.", id);
        cafeRepository.deleteById(id);
    }
}
