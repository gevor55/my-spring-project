package com.myspringproject.service.cafe;

import com.myspringproject.dto.cafe.CafeRequestDto;
import com.myspringproject.dto.cafe.CafeResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CafeServiceImplTest {

    @Autowired
    private CafeService cafeService;

    @Test
    void findAll() {

        List<CafeResponseDto> result = cafeService.findAll();
        Assertions.assertThat(result).hasSize(2);

    }

    @Test
    void findById() {

        Optional<CafeResponseDto> maybe = cafeService.findById(1L);
        assertTrue(maybe.isPresent());

        maybe.ifPresent(user -> assertEquals("The Garden", user.getName()));

    }

    @Test
    void create() {

        CafeRequestDto cafeRequestDto = new CafeRequestDto(
                "Pizza",
                "Yerevan"
        );

        CafeResponseDto cafeResponseDto = cafeService.create(cafeRequestDto);

        assertEquals(cafeRequestDto.getName(), cafeResponseDto.getName());
        assertEquals(cafeRequestDto.getAddress(), cafeResponseDto.getAddress());


    }

    @Test
    void updateByName() {


        CafeResponseDto updateDto = cafeService.updateByName("The Garden",
                new CafeRequestDto(
                        "b",
                        "b"
                ));

        assertEquals("b", updateDto.getName());
        assertEquals("b", updateDto.getAddress());
    }

//
//    @Test
//    void deleteById() {
//    }
}