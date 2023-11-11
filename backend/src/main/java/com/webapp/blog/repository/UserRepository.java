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

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User findById(long id) {
        System.out.println(id);
        
        String sql = "SELECT first_name FROM users WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rownumber) throws SQLException {   
	        	User user=new User();  
	        	user.setFirstName(rs.getString(1));  
	        	// user.setFirstName(rs.getString(2));  
	        	// user.setPassword(rs.getString(4));  
	        	return user;  
	        }  
        }, id);
    }

    public Boolean exists(String userEmail) {
        String sql = "SELECT id FROM users WHERE email = ?";
        List<User> userExists = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class), userEmail);
        return !userExists.isEmpty();
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
        jdbcTemplate.update(sql, userData.getFirstName(), userData.getLastName(), userData.getEmail(), userData.getPassword());
        return true;
    }
}