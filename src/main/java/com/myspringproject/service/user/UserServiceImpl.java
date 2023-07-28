package com.myspringproject.service.user;

import com.myspringproject.advice.NotFoundException;
import com.myspringproject.dto.user.*;
import com.myspringproject.entities.User;
import com.myspringproject.mapper.user.UserMapper;
import com.myspringproject.repository.UserRepository;
import com.myspringproject.validation.UserValidatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidatorService userValidator;
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserResponseDto> findAllActiveUsers() {
        return userRepository.findAllByUserStatus(UserStatus.ACTIVE)
                .stream()
                .map(userMapper::entityToDto)
                .toList();
    }

    @Override
    public Optional<UserResponseDto> findById(Long id) {
        log.info("Search user with id: {}.", id);

        return Optional.ofNullable(userRepository.findById(id)
                .map(userMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found")));
    }

    @Override
    public UserResponseDto create(UserCreationDto dto) {
        log.info("Starting create user ");

        userValidator.existsByUsername(dto.getUsername());

        log.info("User successfully created");

        return Optional.of(dto)
                .map(userMapper::dtoToEntity)
                .map(userRepository::save)
                .map(userMapper::entityToDto)
                .orElseThrow();
    }

    @Override
    public Optional<UserResponseDto> update(Long id, UserUpdateDto userDto) {

        log.info("Starting update user with id: {}", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found"));

        userValidator.existsByUsername(userDto.getUsername());

        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserStatus(userDto.getUserStatus());
        user.setRole(userDto.getRole());

        userRepository.save(user);

        return Optional.of(userMapper.entityToDto(user));
    }

    @Override
    public void changePassword(Long id, ChangePasswordDto command) {
        log.info("Starting changing user password with id: {}", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found"));


        String currentPassword = user.getPassword();

        boolean isMatches = passwordEncoder.matches(command.getNewPassword(), currentPassword);

        if (isMatches) {
            throw new ValidationException("The new password is the same as the current password.");
        }

        user.setPassword(passwordEncoder.encode(command.getNewPassword()));

        log.info("Password successfully changed");

        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Starting delete user with id: {}.", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found"));

        log.debug("User with id: {} successfully deleted.", id);

        user.setUserStatus(UserStatus.INACTIVE);

        userRepository.save(user);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Failed to retrieve user: " + username));
    }
}