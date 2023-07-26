package com.myspringproject.mapper.user;

import com.myspringproject.dto.user.UserRequestDto;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserMapper {


    public User dtoToEntity(UserRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthdate(dto.getBirthDate());
        user.setUserStatus(dto.getUserStatus());

        return user;
    }

    public UserResponseDto entityToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthdate());
        dto.setUserStatus(user.getUserStatus());

        return dto;
    }
}