package com.myspringproject.service.user;

import com.myspringproject.advice.NotFoundException;
import com.myspringproject.dto.user.UserRequestDto;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.entities.User;
import com.myspringproject.mapper.user.UserMapper;
import com.myspringproject.repository.UserRepository;
import com.myspringproject.validation.UserValidatitorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidatitorService userValidator;
    private final EntityManager entityManager;


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

        log.trace("Starting create user ");

        userValidator.existsByUsername(dto.getUsername());

        log.trace("User successfully created");

        return Optional.of(dto)
                .map(userMapper::dtoToEntity)
                .map(userRepository::save)
                .map(userMapper::entityToDto)
                .orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        log.trace("Starting delete user with id: {}.", id);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id: " + id + " not found"));

        log.debug("User with id: {} successfully deleted.", id);

        user.setUserStatus(UserStatus.INACTIVE);

        userRepository.save(user);

    }
}