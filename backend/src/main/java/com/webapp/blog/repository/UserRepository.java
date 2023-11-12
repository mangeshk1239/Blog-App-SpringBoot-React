package com.webapp.blog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webapp.blog.model.User;
import com.webapp.blog.exception.UserException;

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
        try {
            String sql = "SELECT id FROM users WHERE email = ?";

            Long userId = jdbcTemplate.queryForObject(sql, Long.class, userEmail);
            System.out.println(userId);

            return true;
        } catch (UserException e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean valid(String userPassword) {
        String sql = "SELECT id FROM users WHERE password = ?";
        List<User> validPassword = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class), userPassword);
        return !validPassword.isEmpty();
    }

    public Boolean create(User userData) {
        String sql = """
                    INSERT INTO users (first_name, last_name, email, password)
                    VALUES (?, ?, ?)
                """;
        jdbcTemplate.update(sql, userData.getFirstName(), userData.getLastName(), userData.getEmail(),
                userData.getPassword());
        return true;
    }
}