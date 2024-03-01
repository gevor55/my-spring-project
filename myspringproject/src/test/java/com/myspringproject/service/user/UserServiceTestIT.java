package com.myspringproject.service.user;


import com.myspringproject.advice.NotFoundException;
import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.dto.user.UserUpdateRequest;
import com.myspringproject.entities.User;
import com.myspringproject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.yml")
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Transactional
class UserServiceTestIT {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    void findAllActiveUsers() {

        List<UserResponseDto> activeUsers = userService.findAllActiveUsers();

        assertThat(activeUsers).hasSize(2);

        activeUsers.forEach(user -> Assertions.assertEquals(UserStatus.ACTIVE, user.getUserStatus()));
    }

    @Rollback
    @Transactional
    @Test
    void testNotFoundActiveUsers() {

        userRepository.deleteAll();
        List<UserResponseDto> activeUsers = userService.findAllActiveUsers();

        assertThat(activeUsers).hasSize(0);
    }

    @Test
    public void findById() {
        Optional<User> maybeUser = userRepository.findById(1L);

        assertThat(maybeUser).isNotNull();
    }

    @Test
    void testUserNotFound() {
        assertThrows(NotFoundException.class, () -> userService.findById(3L));
    }

    @Rollback
    @Transactional
    @Test
    void create() {

        RegistrationRequest registrationRequest = createUser();


        UserResponseDto createdUser = userService.create(registrationRequest);


        assertNotNull(createdUser);
        assertEquals(registrationRequest.getUsername(), createdUser.getUsername());
        assertEquals(registrationRequest.getFirstName(), createdUser.getFirstName());
        assertEquals(registrationRequest.getLastName(), createdUser.getLastName());
        assertEquals(registrationRequest.getBirthDate(), createdUser.getBirthDate());
        assertEquals(registrationRequest.getEmail(), createdUser.getEmail());
        assertEquals(UserStatus.PENDING, createdUser.getUserStatus());
    }

    @Rollback
    @Transactional
    @Test
    void updateExistingUser() {
        Optional<UserResponseDto> user = userService.findById(1L);

        UserUpdateRequest updateRequest = UserUpdateRequest.builder()
                .username("Alex")
                .firstName("Updated")
                .lastName("User")
                .role(Collections.emptyList())
                .build();


        Optional<UserResponseDto> updatedUser = userService.update(user.get().getUsername(), updateRequest);

        assertTrue(updatedUser.isPresent());
        assertEquals("Alex", updatedUser.get().getUsername());
    }

    @Test
    void testUpdateUserNotFound() {

        UserUpdateRequest updateRequest = UserUpdateRequest.builder()
                .username("Alex")
                .firstName("Updated")
                .lastName("User")
                .role(Collections.emptyList())
                .build();

        assertThrows(NotFoundException.class, () -> userService.update("BBB", updateRequest));

    }

    @Rollback
    @Transactional
    @Test
    public void deleteByUsername() {

        Optional<User> user = userRepository.findByUsername("user");

        userService.deleteByUsername(user.get().getUsername());

        Optional<User> userAfterDeletion = userRepository.findByUsername("user");

        assertEquals(UserStatus.INACTIVE, userAfterDeletion.get().getUserStatus());
    }


    @Test
    public void deleteByUsernameNotFound() {

        assertThrows(NotFoundException.class, () -> userService.deleteByUsername("AAA"));

    }

    private RegistrationRequest createUser() {
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

