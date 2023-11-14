package com.webapp.blog.repository;

import org.springframework.stereotype.Repository;

import com.webapp.blog.model.Blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class BloggerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void create(Blog blogData, long userId) {
        String sql = 
        """
            INSERT INTO blogs (user_id, title, description)
            VALUES (?, ?, ?)
        """;
        try {
            jdbcTemplate.update(sql, userId, blogData.getTitle(), blogData.getDescription());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
