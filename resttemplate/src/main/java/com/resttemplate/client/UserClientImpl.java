package com.resttemplate.client;

import com.resttemplate.dto.RegistrationRequest;
import com.resttemplate.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserClientImpl implements UserClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String GET_USER_PATH = "/api/users";
    private static final String GET_USER_BY_ID_PATH = "/api/users/{userId}";

    @Override
    public Collection<UserResponseDto> listUsers() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<List<UserResponseDto>> response = restTemplate.exchange(
                GET_USER_PATH,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {
                }
        );

        if (!Objects.requireNonNull(response.getBody()).isEmpty()) {
            response.getBody().forEach(System.out::println);
        }

        return response.getBody();
    }

    @Override
    public Optional<UserResponseDto> getUserById(Long userId) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        UserResponseDto dto = restTemplate.getForObject(GET_USER_BY_ID_PATH, UserResponseDto.class, userId);

        return Optional.ofNullable(dto);

    }

    @Override
    public UserResponseDto create(RegistrationRequest newUser) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<UserResponseDto> response = restTemplate.postForEntity(GET_USER_PATH, newUser, UserResponseDto.class);

        return response.getBody();
    }
}
