package com.myspringproject.service.user;

import com.myspringproject.dto.user.UserCreationDto;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserUpdateDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAll();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto create(UserCreationDto user);

    void deleteById(Long id);

    Optional<UserResponseDto> update(Long id, UserUpdateDto userDto);

}