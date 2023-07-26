//package com.myspringproject.jdbc;
//
//import com.myspringproject.entities.Cafe;
//import lombok.RequiredArgsConstructor;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class CafeJdbcService {
//
//    private final JdbcTemplate jdbcTemplate;
//
//
//    public List<Cafe> findAll() {
//
//        String sql = """
//                select * from cafe;
//                """;
//        return jdbcTemplate.query(sql, new CafeRowMapper());
//    }
//
//    public Optional<Cafe> findById(Long id) {
//
//        String sql = """
//                select * from cafe
//                where id = ?
//                """;
//
//        List<Cafe> cafes = jdbcTemplate.query(sql, new CafeRowMapper(), id);
//
//        return cafes.stream()
//                .findFirst();
//    }
//
//    public int insert(Cafe cafe) {
//
//        String sql = """
//                insert into cafe(name, address)
//                VALUES (?, ?)
//                """;
//        return jdbcTemplate.update(
//                sql, cafe.getName(),
//                cafe.getAddress());
//    }
//
//}
