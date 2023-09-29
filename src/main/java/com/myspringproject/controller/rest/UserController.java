package com.myspringproject.controller.rest;


import com.myspringproject.dto.user.*;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<Collection<UserResponseDto>> findAllActiveUser() {
        Collection<UserResponseDto> userResponseDtos = userService.findAllActiveUsers();

        return ResponseEntity.ok(userResponseDtos);
    }

    @PatchMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable("id") Long id, @Valid ChangePasswordCommand dto) {
        userService.changePassword(id, dto);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDto>> findById(@PathVariable("id") Long id) {
        Optional<UserResponseDto> userResponseDto = userService.findById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody UserRegistrationCommand userDto) {
        UserResponseDto userResponseDto = userService.create(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDto>> update(@PathVariable("id") Long id, @Valid @RequestBody UserUpdateCommand user) {
        Optional<UserResponseDto> userResponseDto = userService.update(id, user);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable("username") String username) {
        userService.delete(username);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/search")
    public ResponseEntity<Collection<UserResponseDto>> searchUsers(UserSearchCommand command) {
        Collection<UserResponseDto> userResponseDtos = userService.search(command);

        return ResponseEntity.ok(userResponseDtos);
    }
}
