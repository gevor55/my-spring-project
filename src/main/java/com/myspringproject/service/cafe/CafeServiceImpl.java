package com.myspringproject.service.cafe;

import com.myspringproject.advice.NotFoundException;
import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.entities.Cafe;
import com.myspringproject.mapper.cafe.CafeMapper;
import com.myspringproject.repository.CafeRepository;
import com.myspringproject.validation.CafeValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class CafeServiceImpl implements CafeService {

    private final CafeRepository cafeRepository;
    private final CafeMapper cafeMapper;
    private final CafeValidatorService cafeValidatorService;


    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;


    @Override
    public List<CafeResponseDto> findAll() {

        return cafeRepository.findAll()
                .stream()
                .map(cafeMapper::entityToDto)
                .toList();
    }

    @Override
    public Optional<CafeResponseDto> findById(Long id) {
        log.trace("Search cafe with id: {}.", id);

        return Optional.ofNullable(cafeRepository.findById(id)
                .map(cafeMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("Cafe: " + id + " not found")));
    }

    @Override
    public CafeResponseDto create(CafeRequestDto dto) {

        log.debug("Cafe successfully created.");

        cafeValidatorService.checkAddress(dto.getAddress());

        return Optional.of(dto)
                .map(cafeMapper::dtoToEntity)
                .map(cafeRepository::save)
                .map(cafeMapper::entityToDto)
                .orElseThrow();
    }

    @Override
    public CafeResponseDto updateByName(String name, CafeRequestDto dto) {
        log.trace("Update delete cafe with name: {}.", name);

        cafeValidatorService.checkAddress(dto.getAddress());

        Cafe cafe = cafeRepository.findByName(name);

        if (cafe == null) {
            throw new NotFoundException("Cafe: " + name + " not found");
        }

        cafe.setName(dto.getName());

        cafe.setAddress(dto.getAddress());

        log.debug("Cafe with name: {} successfully updated.", name);

        cafeRepository.save(cafe);

        return cafeMapper.entityToDto(cafe);
    }

    @Override
    public void deleteById(Long id) {
        log.trace("Starting delete cafe with id: {}.", id);

        Cafe cafe = cafeRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Cafe: " + id + " not found"));

        log.debug("Cafe with id: {} successfully deleted.", id);

        cafeRepository.deleteById(cafe.getId());
    }

    @Override
    public Page<CafeResponseDto> search(String name, String address, Integer pageNumber, Integer pageSize) {


        Page<Cafe> cafes = cafeRepository.findAllByNameStartsWithIgnoreCaseOrAddressStartsWithIgnoreCase(name, address, null);

        if (cafes.isEmpty()) {
            log.debug("Cafe not found not found.");
            throw new NotFoundException("Cafe not found not found.");
        }

        return new PageImpl<>(cafes.stream()
                .map(cafe -> {
                    CafeResponseDto dto = new CafeResponseDto();
                    dto.setName(cafe.getName());
                    dto.setAddress(cafe.getAddress());
                    return dto;
                }).toList());
    }

//    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize) {
//        int queryPageNumber;
//        int queryPageSize;
//
//        if (pageNumber != null && pageNumber > 0) {
//            queryPageNumber = pageNumber - 1;
//        } else {
//            queryPageNumber = DEFAULT_PAGE;
//        }
//
//        if (pageSize == null) {
//            queryPageSize = DEFAULT_PAGE_SIZE;
//        } else {
//            if (pageSize > 1000) {
//                queryPageSize = 1000;
//            } else {
//                queryPageSize = pageSize;
//            }
//
//        }
//
//        return PageRequest.of(queryPageNumber, queryPageSize);
//    }
}
