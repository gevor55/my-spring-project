package com.myspringproject.service.cafe.impl;

import com.myspringproject.advice.NoSuchDataException;
import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.mapper.cafe.CafeMapper;
import com.myspringproject.model.Cafe;
import com.myspringproject.repository.CafeRepository;
import com.myspringproject.service.cafe.CafeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return cafeRepository.findAll()
                .stream()
                .map(cafeMapper::entityToDto)
                .toList();
    }

    @Override
    public CafeResponseDto findById(Long id) {
        return cafeRepository.findById(id)
                .map(cafeMapper::entityToDto)
                .orElseThrow(() -> new NoSuchDataException("Cafe: " + id + " not found"));
    }

    @Override
    public CafeResponseDto create(CafeRequestDto dto) {
        Cafe cafe = cafeMapper.dtoToEntity(dto);
        cafeRepository.save(cafe);
        return cafeMapper.entityToDto(cafe);
    }

    @Override
    public CafeResponseDto updateByName(String name, CafeRequestDto dto) {
        Cafe cafe = cafeRepository.findByName(name);
        if (cafe == null) {
            throw new NoSuchDataException("Cafe: " + name + " not found");
        }
        cafe.setName(dto.getName());
        cafe.setAddress(dto.getAddress());
        cafeRepository.save(cafe);
        return cafeMapper.entityToDto(cafe);
    }

    @Override
    public void deleteById(Long id) {
        log.trace("Starting delete cafe with id: {}.", id);

        cafeRepository.findById(id)
                .orElseThrow(() -> new NoSuchDataException("Cafe: " + id + " not found"));

        log.debug("Cafe with id: {} successfully deleted.", id);

        cafeRepository.deleteById(id);
    }
}
