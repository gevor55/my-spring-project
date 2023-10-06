//package com.myspringproject.jdbcTemplate;
//
//import com.myspringproject.entities.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserJdbcService {
//
//    private final JdbcTemplate jdbcTemplate;
//
//
//    public List<User> findAll() {
//
//        String sql = """
//                select * from users;
//                """;
//        return jdbcTemplate.query(sql, new UserRowMapper());
//    }
//
//    public Optional<User> findById(Long id) {
//
//        String sql = """
//                select * from users
//                where id = ?
//                """;
//
//        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), id);
//
//        return users.stream()
//                .findFirst();
//    }
//
//    public int insert(User cafe) {
//
//        String sql = """
//                insert into users(birth_date, email, first_name , last_name  , password , status, username)
//                values (?, ?, ?, ?, ?, ?, ?)
//                """;
//
//        return jdbcTemplate.update(sql, cafe.getBirthdate(), cafe.getEmail(), cafe.getFirstName(),
//                cafe.getLastName(), cafe.getPassword(), cafe.getUserStatus(), cafe.getUsername());
//
//
//    }
//
//}
