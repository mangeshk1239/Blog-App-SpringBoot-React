package com.webapp.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.blog.model.User;
import com.webapp.blog.service.UserService;

@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User userData) {
        Boolean userExists = userService.exists(userData.getEmail());

        if (userExists == true) {
            return ResponseEntity.badRequest()
            .body(Map.of("success", false, "message", "User already exists"));
        }

        userService.create(userData);

        return ResponseEntity.ok()
        .body(Map.of("success", true, "message", "Registered Successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody User userData) {
        Boolean userValid = userService.valid(userData.getEmail(), userData.getPassword());

        if (userValid == true) {
            return ResponseEntity.ok()
            .body(Map.of("success", true, "message", "Logged In Successfully"));
        }

        return ResponseEntity.ok()
        .body(Map.of("success", false, "message", "Invalid Email or Password"));
    }
}