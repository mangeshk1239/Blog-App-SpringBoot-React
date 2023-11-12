package com.webapp.blog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webapp.blog.model.User;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findById(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rownumber) throws SQLException {
                User user = new User();
                user.setId(rs.getLong(1));
                user.setEmail(rs.getString(2));
                user.setFirstName(rs.getString(3));
                user.setLastName(rs.getString(4));
                user.setPassword(rs.getString(5));
                return user;
            }
        }, id);
    }

    public Boolean exists(String userEmail) {
        String sql = "SELECT id FROM users WHERE email = ? LIMIT 1";        
        try {
            Long userId = jdbcTemplate.queryForObject(sql, Long.class, userEmail);
            return userId != null;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean valid(String userEmail, String userPassword) {
        String sql = "SELECT id FROM users WHERE email = ? AND password = ? LIMIT 1";
        try {
            Long userId = jdbcTemplate.queryForObject(sql, Long.class, userEmail, userPassword);
            return userId != null;
        } catch (Exception e) {
            return false;
        }
    }

    public void create(User userData) {
        String sql = 
        """
            INSERT INTO users (first_name, last_name, email, password)
            VALUES (?, ?, ?, ?)
        """;
        try {                    
            jdbcTemplate.update(sql, userData.getFirstName(), userData.getLastName(), userData.getEmail(),
            userData.getPassword());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}