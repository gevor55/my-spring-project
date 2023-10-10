package com.myspringproject.config.security.jwt;


import com.myspringproject.dto.jwt.JwtRequest;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.entities.User;
import com.myspringproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authenticate")
public class JWTController {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @PostMapping
    public String getTokenForAuthenticatedUser(@RequestBody JwtRequest authRequest) {

        User user = userRepository.findByUsername(authRequest.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username " + authRequest.getUsername()));

        if (user.getUserStatus().equals(UserStatus.PENDING) ||
            user.getUserStatus().equals(UserStatus.INACTIVE)) {
            throw new ValidationException("You have not been verified by email");
        }

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new ValidationException("Invalid user credentials");
        }
    }
}
