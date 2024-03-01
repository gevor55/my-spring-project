package com.myspringproject.controller.rest.user;


import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserSearchRequest;
import com.myspringproject.dto.user.UserUpdateRequest;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> findAllActiveUser() {
        List<UserResponseDto> userResponseDtos = userService.findAllActiveUsers();

        return ResponseEntity.ok(userResponseDtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserResponseDto>> findById(@PathVariable("id") Long id) {
        Optional<UserResponseDto> userResponseDto = userService.findById(id);

        return ResponseEntity.ok(userResponseDto);
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> register(@Valid @RequestBody RegistrationRequest userDto) {
        UserResponseDto userResponseDto = userService.create(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @PutMapping("/{username}")
    public ResponseEntity<Optional<UserResponseDto>> update(@PathVariable("username") String username, @Valid @RequestBody UserUpdateRequest user) {
        Optional<UserResponseDto> userResponseDto = userService.update(username, user);

        return ResponseEntity.ok(userResponseDto);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> delete(@PathVariable("username") String username) {
        userService.deleteByUsername(username);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/search")
    public ResponseEntity<Collection<UserResponseDto>> search(UserSearchRequest command) {
        Collection<UserResponseDto> userResponseDtos = userService.search(command);

        return ResponseEntity.ok(userResponseDtos);
    }
}
