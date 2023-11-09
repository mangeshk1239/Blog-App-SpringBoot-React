package com.webapp.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/blogger")
public class BloggerController {

    @GetMapping("/{id}")
    public ResponseEntity<Object> createUser(@PathVariable(value = "id") long id) {
        System.out.println("COMING HERE");
        System.out.println(id);
        return new ResponseEntity<Object>("data", HttpStatus.OK);
    }
}
