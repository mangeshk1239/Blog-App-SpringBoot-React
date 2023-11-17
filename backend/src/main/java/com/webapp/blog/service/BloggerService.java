package com.webapp.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.blog.model.Blog;
import com.webapp.blog.repository.BloggerRepository;

@Service
public class BloggerService {
    @Autowired
    BloggerRepository bloggerRepository;

    public void create(Blog blogdata, long userId) {
        bloggerRepository.create(blogdata, userId);
    }

    public List<Blog> fetch(long userId) {
        return bloggerRepository.fetch(userId);
    }
}
