package com.myspringproject.repository;

import com.myspringproject.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CafeRepository extends JpaRepository<Cafe, Long>{
    Cafe findByName(String name);

    void deleteById(Long id);
}
