package com.myspringproject.service.user;

import com.myspringproject.dto.user.UserRequestDto;
import com.myspringproject.dto.user.UserResponseDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAll();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto create(UserRequestDto user);

    void deleteById(Long id);

}