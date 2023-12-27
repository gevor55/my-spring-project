package com.myspringproject.service.user;

import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserSearchRequest;
import com.myspringproject.dto.user.UserUpdateRequest;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAllActiveUsers();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto create(RegistrationRequest user);

    void deleteByUsername(String username);

    Optional<UserResponseDto> update(String username, UserUpdateRequest userDto);

//    void changePassword(Long id, ChangePasswordRequest changePasswordRequest);

    Collection<UserResponseDto> search(UserSearchRequest command);

}