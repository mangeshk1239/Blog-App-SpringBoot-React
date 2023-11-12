package com.webapp.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        HashMap<String, String> data = new HashMap<>();
        Boolean userExists = userService.exists(userData.getEmail());
        Boolean validPassword = userService.valid(userData.getPassword());

        if (userExists == true && validPassword == true) {
            data.put("success", "true");
            data.put("message", "Registered Successfully");
            return new ResponseEntity<Object>(data, HttpStatus.OK);
        }

        data.put("success", "false");
        data.put("message", "Invalid Email or Password");
        return new ResponseEntity<Object>(data, HttpStatus.BAD_REQUEST);
    }
}