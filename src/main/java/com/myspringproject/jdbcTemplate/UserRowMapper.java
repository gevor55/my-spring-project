//package com.myspringproject.jdbcTemplate;
//
//import com.myspringproject.entities.User;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class UserRowMapper implements RowMapper<User> {
//    @Override
//    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//        User user = new User(
//                rs.getString("firstName"),
//                rs.getString("lastName"),
//                rs.getString("email"),
//                rs.getString("password"),
//                new ArrayList<>()
//        );
//        return user;
//    }
//
//
//}
