package com.myspringproject.service.user;

import com.myspringproject.advice.NotFoundException;
import com.myspringproject.dto.user.UserRequestDto;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.mapper.user.UserMapper;
import com.myspringproject.repository.UserRepository;
import com.myspringproject.validation.UserValidatitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidatitorService userValidator;


    @Override
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::entityToDto)
                .toList();
    }

    @Override
    public Optional<UserResponseDto> findById(Long id) {
        log.trace("Search user with id: {}.", id);
        return Optional.ofNullable(userRepository.findById(id)
                .map(userMapper::entityToDto)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found")));
    }

    @Override
    public UserResponseDto create(UserRequestDto dto) {

        log.debug("Cafe successfully created.");

        userValidator.existsByUsername(dto.getUsername());

        return Optional.of(dto)
                .map(userMapper::dtoToEntity)
                .map(userRepository::save)
                .map(userMapper::entityToDto)
                .orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        log.trace("Starting delete user with id: {}.", id);

        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found"));

        log.debug("User with id: {} successfully deleted.", id);

        userRepository.deleteById(id);
    }
}