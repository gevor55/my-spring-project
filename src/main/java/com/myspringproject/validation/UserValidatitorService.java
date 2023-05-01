package com.myspringproject.validation;

import com.myspringproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserValidatitorService {

    private final UserRepository userRepository;

    public void existsByUsername(String username) {

        boolean exists = userRepository.findByUsername(username);

        if (exists) {
            throw new IllegalArgumentException("This username has benn registered. Please choose another one.");
        }
    }


}
