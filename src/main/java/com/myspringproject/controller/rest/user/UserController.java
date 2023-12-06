package com.myspringproject.controller.rest.user;


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
    public ResponseEntity<Void> changePassword(@PathVariable("id") Long id, @Valid ChangePasswordRequest dto) {
        userService.changePassword(id, dto);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDto>> findById(@PathVariable("id") Long id) {
        Optional<UserResponseDto> userResponseDto = userService.findById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody RegistrationRequest userDto) {
        UserResponseDto userResponseDto = userService.create(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Optional<UserResponseDto>> update(@PathVariable("username") String username, @Valid @RequestBody UserUpdateRequest user) {
        Optional<UserResponseDto> userResponseDto = userService.update(username, user);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        userService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/search")
    public ResponseEntity<Collection<UserResponseDto>> search(UserSearchRequest command) {
        Collection<UserResponseDto> userResponseDtos = userService.search(command);

        return ResponseEntity.ok(userResponseDtos);
    }
}
