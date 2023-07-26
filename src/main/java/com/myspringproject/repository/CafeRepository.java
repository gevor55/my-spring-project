package com.myspringproject.repository;

import com.myspringproject.entities.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, Long> {

    Cafe findByName(String name);

    void deleteById(Long id);

    boolean existsByAddress(String address);

    List<Cafe> findAllByNameOrAddress(String name, String address);

}
