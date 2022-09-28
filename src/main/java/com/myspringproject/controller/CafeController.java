package com.myspringproject.controller;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.service.cafe.CafeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CafeController {
    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @GetMapping("/cafes")
    public List<CafeResponseDto> findAll() {
        return cafeService.findAll();
    }

    @GetMapping("/cafes/{id}")
    public CafeResponseDto findById(@PathVariable long id) {
        return cafeService.findById(id);
    }

    @PostMapping("/cafes")
    public CafeResponseDto create(@RequestBody CafeRequestDto cafeDto) {
        return cafeService.create(cafeDto);
    }

    @PutMapping("/cafes/{name}")
    public CafeResponseDto updateByName(@PathVariable String name, @RequestBody CafeRequestDto cafe) {
        return cafeService.updateByName(name, cafe);
    }

    @DeleteMapping("/cafes/{id}")
    public void deleteById(@PathVariable long id) {
        cafeService.deleteById(id);
    }

}
