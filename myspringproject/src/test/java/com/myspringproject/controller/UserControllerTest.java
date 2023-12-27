package com.myspringproject.controller;

import com.myspringproject.controller.rest.user.UserController;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userServiceImpl;

    @MockBean
    Pageable pageable;


    @Test
    public void findAllActiveUsers() throws Exception {

        List<UserResponseDto> allActiveUsers = userServiceImpl.findAllActiveUsers();

        given(userServiceImpl.findAllActiveUsers()).willReturn(allActiveUsers);

        mockMvc.perform(get("/api/users")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void findById() throws Exception {
        Optional<UserResponseDto> user = userServiceImpl.findAllActiveUsers().stream()
                .findFirst();

        given(userServiceImpl.findById(any(Long.class))).willReturn(user);

        mockMvc.perform(get("/api/users/" + new Random().nextLong())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
