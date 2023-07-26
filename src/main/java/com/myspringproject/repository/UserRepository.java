package com.myspringproject.repository;


import com.myspringproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT COUNT(*) > 0 FROM users WHERE username = ?", nativeQuery = true)
    boolean findByUsername(String username);
}
