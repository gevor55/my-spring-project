package com.myspringproject.controller.rest;


import com.myspringproject.dto.user.UserCreationDto;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserUpdateDto;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserResponseDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserResponseDto> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public UserResponseDto create(@Valid @RequestBody UserCreationDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public Optional<UserResponseDto> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
        userService.deleteById(id);
    }
}
