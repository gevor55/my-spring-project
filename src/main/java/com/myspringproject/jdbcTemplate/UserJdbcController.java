//package com.myspringproject.jdbcTemplate;
//
//import com.myspringproject.entities.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("jdbc/user")
//@RequiredArgsConstructor
//public class UserJdbcController {
//
//    private final UserJdbcService userJdbcService;
//
//
//    @GetMapping
//    public List<User> findAll() {
//        return userJdbcService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Optional<User> findAll(@PathVariable("id") Long id) {
//        return userJdbcService.findById(id);
//    }
//
//
//    @PostMapping
//    public int create(@RequestBody User cafe) {
//        return userJdbcService.insert(cafe);
//    }
//}
