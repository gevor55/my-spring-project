//package com.myspringproject.jdbc;
//
//import com.myspringproject.entities.Cafe;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class CafeRowMapper implements RowMapper<Cafe> {
//    @Override
//    public Cafe mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new Cafe(
//                rs.getLong("id"),
//                rs.getString("name"),
//                rs.getString("address"),
//                rs.getArray("cafe")
//        );
//    }
//}
