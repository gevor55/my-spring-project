package com.myspringproject.mapper.user;

import com.myspringproject.dto.user.UserRegistrationCommand;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.entities.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserMapper {

    private final PasswordEncoder passwordEncoder;


    public User dtoToEntity(UserRegistrationCommand dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthdate(dto.getBirthDate());
        user.setUserStatus(dto.getUserStatus());
        user.setRole(dto.getRole());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        return user;
    }

    public UserResponseDto entityToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthdate());
        dto.setUserStatus(user.getUserStatus());
        dto.setRole(user.getRole());

        return dto;
    }
}