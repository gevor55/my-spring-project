package com.myspringproject.controller.rest;


import com.myspringproject.dto.user.*;
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
    public List<UserResponseDto> findAllActiveUser() {
        return userService.findAllActiveUsers();
    }

    @GetMapping("/login")
    public void login(@Valid LoginCommand command) {
        userService.login(command);
    }

    @PatchMapping("/{id}/change-password")
    public void changePassword(@PathVariable("id") Long id, @Valid ChangePasswordCommand dto) {

        userService.changePassword(id, dto);

    }

    @GetMapping("/{id}")
    public Optional<UserResponseDto> findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/register")
    public UserResponseDto register(@Valid @RequestBody UserRegistrationCommand userDto) {
        return userService.create(userDto);
    }

    @PutMapping("/{id}")
    public Optional<UserResponseDto> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateCommand user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("username") String username) {
        userService.delete(username);
    }


    @GetMapping("/search")
    public List<UserResponseDto> searchUsers(UserSearchCommand command) {

        return userService.searchUsers(command);
    }
}
