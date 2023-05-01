package com.myspringproject.repository;

import com.myspringproject.entities.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Cafe findByName(String name);

    void deleteById(Long id);

    boolean existsByAddress(String address);

}
