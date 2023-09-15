package com.myspringproject.controller.rest;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/cafes")
@RequiredArgsConstructor
public class CafeController {

    private final CafeService cafeService;


    @GetMapping()
    public ResponseEntity<Collection<CafeResponseDto>> findAll() {
        Collection<CafeResponseDto> cafeResponseDtos = cafeService.findAll();

        return ResponseEntity.ok(cafeResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CafeResponseDto>> findById(@PathVariable("id") Long id) {
        Optional<CafeResponseDto> cafeResponseDto = cafeService.findById(id);

        return ResponseEntity.ok(cafeResponseDto);
    }

    @PostMapping()
    public ResponseEntity<CafeResponseDto> create(@Valid @RequestBody CafeRequestDto cafeDto) {

        CafeResponseDto cafeResponseDto = cafeService.create(cafeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(cafeResponseDto);
    }

    @PutMapping("/{name}")
    public ResponseEntity<CafeResponseDto> updateByName(@PathVariable("name") String name, @Valid @RequestBody CafeRequestDto cafe) {
        CafeResponseDto cafeResponseDto = cafeService.updateByName(name, cafe);

        return ResponseEntity.ok(cafeResponseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {

        cafeService.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
