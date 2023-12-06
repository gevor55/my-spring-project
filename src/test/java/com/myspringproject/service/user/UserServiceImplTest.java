package com.myspringproject.service.user;


import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.dto.user.UserUpdateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserServiceImplTest {


    @Autowired
    private UserService userService;

    @Test
    void findAllActiveUsers() {
        List<UserResponseDto> activeUsers = userService.findAllActiveUsers();

        activeUsers.forEach(user -> Assertions.assertEquals(UserStatus.ACTIVE, user.getUserStatus()));
    }

    @Test
    void create() {
        // Given
        RegistrationRequest registrationRequest = createValidRegistrationRequest();

        // When
        UserResponseDto createdUser = userService.create(registrationRequest);

        // Then
        assertNotNull(createdUser);
        assertEquals(registrationRequest.getUsername(), createdUser.getUsername());
        assertEquals(registrationRequest.getFirstName(), createdUser.getFirstName());
        assertEquals(registrationRequest.getLastName(), createdUser.getLastName());
        assertEquals(registrationRequest.getBirthDate(), createdUser.getBirthDate());
        assertEquals(registrationRequest.getEmail(), createdUser.getEmail());
        assertEquals(UserStatus.PENDING, createdUser.getUserStatus());
    }

    @Test
    void update() {
        UserResponseDto createdUser = userService.create(createValidRegistrationRequest());

        UserUpdateRequest updateRequest = UserUpdateRequest.builder()
                .username("Alex")
                .firstName("Updated")
                .lastName("User")
                .role(Collections.emptyList())
                .build();


        Optional<UserResponseDto> updatedUser = userService.update(createdUser.getUsername(), updateRequest);

        assertTrue(updatedUser.isPresent());
        assertEquals("Alex", updatedUser.get().getUsername());
    }


    private RegistrationRequest createValidRegistrationRequest() {
        return RegistrationRequest.builder()
                .username("testUser")
                .firstName("testName")
                .lastName("testName")
                .birthDate(LocalDate.now())
                .email("test@example.com")
                .password("password")
                .confirmPassword("password")
                .build();
    }
}

