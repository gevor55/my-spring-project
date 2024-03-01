package com.myspringproject.service.user;

import com.myspringproject.controller.rest.user.UserController;
import com.myspringproject.dto.user.UserResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class UserServiceTestUnit {

    @Mock
    UserService userService;

    @InjectMocks
    UserController userController;


    @Test
    public void findAllActiveUser_Return_Valid_Response_Entity() {

        //given
        List<UserResponseDto> users = userService.findAllActiveUsers();
        doReturn(users).when(this.userService).findAllActiveUsers();

        //when
        var responseEntity = this.userController.findAllActiveUser();

        //then
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(users, responseEntity.getBody());

    }
}
