package com.myspringproject.jdbc;

import com.myspringproject.model.Cafe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("jdbc/cafes")
@RequiredArgsConstructor
public class CafeJdbcController {

    private final CafeJdbcService cafeJdbcService;


    @GetMapping
    public List<Cafe> findAll() {
        return cafeJdbcService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cafe> findAll(@PathVariable("id") Long id) {
        return cafeJdbcService.findById(id);
    }


    @PostMapping
    public int create(@RequestBody Cafe cafe) {
        return cafeJdbcService.insert(cafe);
    }
}
