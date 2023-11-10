package com.webapp.blog.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.webapp.blog.model.User;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> findById(long id) {
        return jdbcTemplate.query(
            "SELECT * FROM users WHERE id = '" + id + "'",
            BeanPropertyRowMapper.newInstance(User.class)
        );
    }

    public Boolean exists(String userEmail) {
        List<User> userExists = jdbcTemplate.query(
            "SELECT id FROM users WHERE email = '" + userEmail + "'",
            BeanPropertyRowMapper.newInstance(User.class)
        );

        return !userExists.isEmpty();
    }

    public Boolean valid(String userPassword) {
        List<User> validPassword = jdbcTemplate.query(
            "SELECT id FROM users WHERE password = '" + userPassword + "'",
            BeanPropertyRowMapper.newInstance(User.class)
        );

        return !validPassword.isEmpty();
    }

    public Boolean create(User userData) {
        jdbcTemplate.update(
                "INSERT INTO users (first_name, last_name, email, password) VALUES ('" + userData.getFirstName()
                        + "', '" + userData.getLastName() + "', '" + userData.getEmail() + "', '"
                        + userData.getPassword() + "')");
        return true;
    }
}