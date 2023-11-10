package com.webapp.blog.repository;

import org.springframework.stereotype.Repository;

import com.webapp.blog.model.Blog;
import com.webapp.blog.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class BloggerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public String create(User userData, Blog blogData) {
        System.out.println();
        return "asd";
    }
}
