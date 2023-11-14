package com.webapp.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webapp.blog.model.Blog;
import com.webapp.blog.model.User;
import com.webapp.blog.service.BloggerService;
import com.webapp.blog.service.UserService;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/blogger")
public class BloggerController {

    @Autowired
    BloggerService bloggerService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUser(@PathVariable(value = "id") long id) {
        return new ResponseEntity<Object>("data", HttpStatus.OK);
    }

    @PostMapping("/{id}/create")
    public ResponseEntity<Object> createUser(@PathVariable(value = "id") long userId, @RequestBody Blog blogData) {
        bloggerService.create(blogData, userId);
        return new ResponseEntity<Object>("data", HttpStatus.OK);
    }
}