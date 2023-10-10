package com.myspringproject.service.user;

import com.myspringproject.dto.user.*;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Collection<UserResponseDto> findAllActiveUsers();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto create(RegistrationRequest user);

    void delete(Long id);

    Optional<UserResponseDto> update(Long id, UserUpdateRequest userDto);

    void changePassword(Long id, ChangePasswordRequest changePasswordRequest);

    Collection<UserResponseDto> search(UserSearchRequest command);

}