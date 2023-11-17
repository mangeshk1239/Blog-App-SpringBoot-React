package com.webapp.blog.repository;

import org.springframework.stereotype.Repository;

import com.webapp.blog.model.Blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class BloggerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Blog> fetch(long userId) {
        String sql = "SELECT * FROM blogs WHERE user_id = ?";
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
        }, userId);
    }

    public void create(Blog blogData, long userId) {
        System.out.println(blogData.getBlogImageUrl());
        String sql = """
                    INSERT INTO blogs (user_id, title, description, preview_description, blog_image_url)
                    VALUES (?, ?, ?, ?, ?)
                """;
        try {
            jdbcTemplate.update(
                sql,
                userId,
                blogData.getTitle(),
                blogData.getDescription(),
                blogData.getPreviewDescription(),
                blogData.getBlogImageUrl()
            );
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
