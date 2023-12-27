package com.resttemplate.client;

import com.resttemplate.dto.RegistrationRequest;
import com.resttemplate.dto.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserClientImplTest {

    @Autowired
    UserClientImpl userClient;

    @Test
    void listUsers() {

        userClient.listUsers();
    }

    @Test
    void getUserById() {
        //todo change implementation
        Optional<UserResponseDto> byId = userClient.getUserById(1L);

        System.out.println(byId);

        assertNotNull(byId);
    }

    @Test
    void testCreateUser() {

        RegistrationRequest newDto = RegistrationRequest.builder()
                .username("testUser")
                .firstName("testName")
                .lastName("testName")
                .birthDate(LocalDate.now())
                .email("test@example.com")
                .password("password")
                .confirmPassword("password")
                .build();

        UserResponseDto saveDto = userClient.create(newDto);

        assertNotNull(saveDto);


    }
}