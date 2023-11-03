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

    public Boolean create(User userData) {
        // jdbcTemplate.query("SELECT * FROM users",
        // BeanPropertyRowMapper.newInstance(User.class));
        jdbcTemplate.update(
            "INSERT INTO users (first_name, last_name, email, password) VALUES ('" + userData.getFirstName() + "', '" + userData.getLastName() + "', '" + userData.getEmail() + "', '" + userData.getPassword() + "')");
        return true;
    }
}