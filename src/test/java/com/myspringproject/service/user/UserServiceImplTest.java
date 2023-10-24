package com.myspringproject.service.user;


import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.mapper.user.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class UserServiceImplTest {


    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void findAllActiveUsers() {
        List<UserResponseDto> activeUsers = userService.findAllActiveUsers();

        Assertions.assertFalse(activeUsers.isEmpty());

        activeUsers.forEach(user -> Assertions.assertEquals(UserStatus.ACTIVE, user.getUserStatus()));
    }
}

