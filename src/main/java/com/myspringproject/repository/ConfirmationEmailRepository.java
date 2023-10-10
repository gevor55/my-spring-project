package com.myspringproject.repository;

import com.myspringproject.entities.ConfirmationEmailToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationEmailRepository extends JpaRepository<ConfirmationEmailToken, Long> {
    ConfirmationEmailToken findByConfirmationToken(String token);
}
