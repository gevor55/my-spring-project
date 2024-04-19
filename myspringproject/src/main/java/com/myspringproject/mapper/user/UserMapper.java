package com.myspringproject.mapper.user;

import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.entities.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserMapper {

    public User dtoToEntity(RegistrationRequest dto) {

        return User.builder()
                .username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthdate(dto.getBirthDate())
                .userStatus(UserStatus.ACTIVE)
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public UserResponseDto entityToDto(User user) {

        return UserResponseDto.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthdate())
                .userStatus(user.getUserStatus())
                .email(user.getEmail())
                .build();
    }
}