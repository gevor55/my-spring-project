package com.myspringproject.repository;

import com.myspringproject.entities.Cafe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Long> {
    Cafe findByName(String name);

    void deleteById(Long id);

    boolean existsByAddress(String address);

    Page<Cafe> findAllByNameStartsWithIgnoreCaseOrAddressStartsWithIgnoreCase(String name, String address, Pageable pageable);

}
