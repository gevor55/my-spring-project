package com.myspringproject.controller;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import com.myspringproject.service.cafe.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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


//    @GetMapping()
//    public String findAll(Model model) {
//        List<CafeResponseDto> cafes = cafeService.findAll();
//        model.addAttribute("cafes", cafes);
//        return "cafes";
//    }

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


    @GetMapping("/search")
    public Page<CafeResponseDto> search(@RequestParam(required = false) String cafeName,
                                        @RequestParam(required = false) String cafeAddress,
                                        @RequestParam(required = false) Integer pageNumber,
                                        @RequestParam(required = false) Integer pageSize) {

        return cafeService.search(cafeName, cafeAddress, pageNumber, pageSize);
    }

}
