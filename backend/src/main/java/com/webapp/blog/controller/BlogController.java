package com.webapp.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.blog.model.Blog;
import com.webapp.blog.service.BlogService;

@Controller
@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/fetch")
    public ResponseEntity<Object> getAll() {
        List<Blog> blogData = blogService.fetchAll();

        return ResponseEntity.ok()
        .body(Map.of("success", true, "data", blogData));
    }
}
