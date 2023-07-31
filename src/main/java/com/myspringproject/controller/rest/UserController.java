package com.myspringproject.controller.rest;


import com.myspringproject.dto.user.*;
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
    public void changePassword(@PathVariable("id") Long id, @Valid ChangePasswordCommand dto) {

        userService.changePassword(id, dto);

    }

    @GetMapping("/{id}")
    public Optional<UserResponseDto> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping()
    public UserResponseDto register(@Valid @RequestBody UserRegistrationCommand userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public Optional<UserResponseDto> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateCommand user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") long id) {
        userService.deleteById(id);
    }


    @GetMapping("/search")
    public List<UserResponseDto> searchUsers(UserSearchCommand command) {

        return userService.searchUsers(command);
    }
}
