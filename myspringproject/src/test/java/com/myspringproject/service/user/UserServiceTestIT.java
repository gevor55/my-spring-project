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
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@TestConfiguration
@Sql({
        "classpath:sql/data.sql"
})
@Transactional
class UserServiceTestIT {


    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindAllActiveUsers() {

        List<UserResponseDto> activeUsers = userService.findAllActiveUsers();

        assertThat(activeUsers).hasSize(1);

        activeUsers.forEach(user -> Assertions.assertEquals(UserStatus.ACTIVE, user.getUserStatus()));
    }

    @Test
    void testNotFoundActiveUsers() {

        userRepository.deleteAll();
        List<UserResponseDto> activeUsers = userService.findAllActiveUsers();

        assertThat(activeUsers).hasSize(0);
    }

    @Test
    public void testFindById() {
        Optional<User> user = userRepository.findById(1L);

        assertThat(user).isNotNull();
    }

    @Test
    void testUserNotFound() {
        assertThrows(NotFoundException.class, () -> userService.findById(3L));
    }


    @Test
    void testCreate() {

        RegistrationRequest registrationRequest = createUser();


        UserResponseDto createdUser = userService.create(registrationRequest);


        assertNotNull(createdUser);
        assertEquals(registrationRequest.getUsername(), createdUser.getUsername());
        assertEquals(registrationRequest.getFirstName(), createdUser.getFirstName());
        assertEquals(registrationRequest.getLastName(), createdUser.getLastName());
        assertEquals(registrationRequest.getBirthDate(), createdUser.getBirthDate());
        assertEquals(registrationRequest.getEmail(), createdUser.getEmail());
        assertEquals(UserStatus.ACTIVE, createdUser.getUserStatus());
    }

    @Test
    void testUpdateExistingUser() {
        Optional<User> user = userRepository.findByUsername("test1");

        UserUpdateRequest updateRequest = UserUpdateRequest.builder()
                .username("Updated")
                .firstName("Updated")
                .lastName("Updated")
                .build();


        Optional<UserResponseDto> updatedUser = userService.update(user.get().getUsername(), updateRequest);

        assertTrue(updatedUser.isPresent());
        assertEquals("Updated", updatedUser.get().getUsername());
    }

    @Test
    void testUpdateUserNotFound() {

        UserUpdateRequest updateRequest = UserUpdateRequest.builder()
                .username("Alex")
                .firstName("Updated")
                .lastName("User")
                .build();

        assertThrows(NotFoundException.class, () -> userService.update("BBB", updateRequest));

    }

    @Test
    void testDeleteByUsername() {

        Optional<User> user = userRepository.findByUsername("test1");

        userService.deleteByUsername(user.get().getUsername());

        Optional<User> userAfterDeletion = userRepository.findByUsername("test1");

        assertEquals(UserStatus.INACTIVE, userAfterDeletion.get().getUserStatus());
    }


    @Test
    void testDeleteByUsernameNotFound() {

        assertThrows(NotFoundException.class, () -> userService.deleteByUsername("AAA"));

    }

    @Test
    void fail_Delete_User_When_User_Status_InActive() {

        Optional<User> user = userRepository.findByUsername("test2");

        assertThrows(ValidationException.class,
                () -> userService.deleteByUsername(user.get().getUsername()));

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

