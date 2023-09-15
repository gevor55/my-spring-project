package com.myspringproject.service.user;

import com.myspringproject.dto.user.*;

import java.util.Collection;
import java.util.Optional;

public interface UserService {

    Collection<UserResponseDto> findAllActiveUsers();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto create(UserRegistrationCommand user);

    void delete(String username);

    Optional<UserResponseDto> update(Long id, UserUpdateCommand userDto);

    void changePassword(Long id, ChangePasswordCommand changePasswordCommand);

    Collection<UserResponseDto> search(UserSearchCommand command);

    void login(LoginCommand command);

}