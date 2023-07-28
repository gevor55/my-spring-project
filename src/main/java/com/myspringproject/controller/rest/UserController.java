package com.myspringproject.controller.rest;


import com.myspringproject.dto.user.ChangePasswordDto;
import com.myspringproject.dto.user.UserCreationDto;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserUpdateDto;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserResponseDto> findAllActiveUser() {
        return userService.findAllActiveUsers();
    }

    @PatchMapping("/{id}/change-password")
    public void changePassword(@PathVariable("id") Long id, @Valid ChangePasswordDto dto) {

        userService.changePassword(id, dto);

    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<UserResponseDto> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserResponseDto create(@Valid @RequestBody UserCreationDto userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<UserResponseDto> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateDto user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
        userService.deleteById(id);
    }
}
