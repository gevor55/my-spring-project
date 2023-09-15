package com.myspringproject.validation;

import com.myspringproject.entities.User;
import com.myspringproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserValidatorService {

    private final UserRepository userRepository;

    public void existsByUsername(String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            throw new IllegalArgumentException("This username has benn registered. Please choose another one.");
        }
    }
}
