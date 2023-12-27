package com.myspringproject.validation;

import com.myspringproject.entities.User;
import com.myspringproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserValidatorService {

    private final UserRepository userRepository;

    public void existsByUsername(String username) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            throw new ValidationException("This username has benn registered. Please choose another one.");
        }
    }

    public void existsByEmail(String email) {

        boolean isExistsByEmail = userRepository.existsByEmail(email);

        if (isExistsByEmail) {
            throw new ValidationException("This email has benn registered. Please choose another one.");
        }
    }
}
