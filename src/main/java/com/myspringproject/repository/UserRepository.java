package com.myspringproject.repository;


import com.myspringproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    void deleteById(Long id);
}
