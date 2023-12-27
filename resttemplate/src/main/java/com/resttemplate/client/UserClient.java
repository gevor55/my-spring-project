package com.resttemplate.client;

import com.resttemplate.dto.RegistrationRequest;
import com.resttemplate.dto.UserResponseDto;

import java.util.Collection;
import java.util.Optional;

public interface UserClient {

    Collection<UserResponseDto> listUsers();

    Optional<UserResponseDto> getUserById(Long userId);

    UserResponseDto create(RegistrationRequest user);


}
