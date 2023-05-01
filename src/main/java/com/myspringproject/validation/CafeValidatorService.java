package com.myspringproject.validation;

import com.myspringproject.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeValidatorService {

    private final CafeRepository cafeRepository;


    public void checkAddress(String address) {

        boolean existsByAddress = cafeRepository.existsByAddress(address);

//        if (existsByAddress) {
//            throw new ValidationException(
//                    Error.builder()
//                            .field("address")
//                            .code("address.duplicated")
//                            .defaultMessage("This address has benn registered. Please choose another one.")
//                            .build()
//            );
//        }

        if (existsByAddress) {
            throw new IllegalArgumentException("This address has benn registered. Please choose another one.");
        }
    }
}
