package com.webapp.blog.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class BloggerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

}
