package com.webapp.blog.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.webapp.blog.model.Blog;

@Repository
public class BlogRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Blog> fetchAll() {
        String sql = "SELECT * FROM blogs";
            return jdbcTemplate.query(sql, new RowMapper<Blog>() {
            @Override
            public Blog mapRow(ResultSet rs, int rownumber) throws SQLException {
                Blog blog = new Blog();
                blog.setId(rs.getLong(1));
                blog.setDescription(rs.getString(2));
                blog.setTitle(rs.getString(3));
                blog.setUserId(rs.getLong(4));
                return blog;
            }
        });
    }
}
