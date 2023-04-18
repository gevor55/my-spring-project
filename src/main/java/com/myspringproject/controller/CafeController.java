package com.myspringproject.controller;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cafe")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;


    @GetMapping()
    public List<CafeResponseDto> findAll() {
        return cafeService.findAll();
    }

    @GetMapping("/{id}")
    public CafeResponseDto findById(@PathVariable long id) {
        return cafeService.findById(id);
    }

    @PostMapping()
    public CafeResponseDto create(@Valid @RequestBody CafeRequestDto cafeDto) {
        return cafeService.create(cafeDto);
    }

    @PutMapping("/{name}")
    public CafeResponseDto updateByName(@PathVariable String name, @Valid @RequestBody CafeRequestDto cafe) {
        return cafeService.updateByName(name, cafe);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        cafeService.deleteById(id);
    }

}
