package com.myspringproject.mapper.user;

import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
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
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setBirthdate(dto.getBirthDate());
        user.setUserStatus(dto.getUserStatus());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setRoles(List.of(roleService.getUserRole()));
        return user;
    }

    public UserResponseDto entityToDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setUsername(user.getUsername());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthdate());
        dto.setUserStatus(user.getUserStatus());
        String role = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.joining(", "));
        dto.setRole(role);

        dto.setEmail(user.getEmail());

        return dto;
    }
}