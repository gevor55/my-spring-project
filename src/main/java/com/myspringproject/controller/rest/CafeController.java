package com.myspringproject.controller.rest;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cafes")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;


    @GetMapping()
    public List<CafeResponseDto> findAll() {
        return cafeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CafeResponseDto> findById(@PathVariable("id") Long id) {
        return cafeService.findById(id);
    }

    @PostMapping()
    public CafeResponseDto create(@Valid @RequestBody CafeRequestDto cafeDto) {
        return cafeService.create(cafeDto);
    }

    @PutMapping("/{name}")
    public CafeResponseDto updateByName(@PathVariable("name") String name, @Valid @RequestBody CafeRequestDto cafe) {
        return cafeService.updateByName(name, cafe);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
        cafeService.deleteById(id);
    }
}
