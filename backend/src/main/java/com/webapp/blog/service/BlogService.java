package com.webapp.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.blog.model.Blog;
import com.webapp.blog.repository.BlogRepository;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public List<Blog> fetchAll() {
        return blogRepository.fetchAll();
    }
}
