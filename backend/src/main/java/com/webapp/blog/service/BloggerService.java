package com.webapp.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.blog.model.Blog;
import com.webapp.blog.model.User;
import com.webapp.blog.repository.BloggerRepository;

@Service
public class BloggerService {
    @Autowired
    BloggerRepository bloggerRepository;

    public String create(User userData, Blog blogdata) {
        return bloggerRepository.create(userData, blogdata);
    }
}
