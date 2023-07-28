package com.myspringproject.repository;


import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findAllByUserStatus(UserStatus userStatus);
}
