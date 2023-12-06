package com.myspringproject.mapper.user;

import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.entities.Role;
import com.myspringproject.entities.User;
import com.myspringproject.repository.RoleRepository;
import com.myspringproject.service.role.RoleService;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Data
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final RoleService roleService;


    public User dtoToEntity(RegistrationRequest dto) {

        return User.builder()
                .username(dto.getUsername())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthdate(dto.getBirthDate())
                .userStatus(UserStatus.PENDING)
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .roles(List.of(roleService.getUserRole()))
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
                .role(user.getRoles().stream()
                        .map(Role::getName)
                        .collect(Collectors.joining(", ")))
                .build();
    }
}