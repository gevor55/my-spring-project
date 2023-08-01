package com.myspringproject.service.user;

import com.myspringproject.dto.user.*;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAllActiveUsers();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto create(UserRegistrationCommand user);

    void deleteById(Long id);

    Optional<UserResponseDto> update(Long id, UserUpdateCommand userDto);

    void changePassword(Long id, ChangePasswordCommand changePasswordCommand);

    List<UserResponseDto> searchUsers(UserSearchCommand command);

    void login(LoginCommand command);

}