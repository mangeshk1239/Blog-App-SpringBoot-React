package com.webapp.blog.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<Object> createUser(@PathVariable(value = "id") long id) {
        System.out.println("COMING HERE");
        System.out.println(id);
        return new ResponseEntity<Object>("data", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody User userData) {
        HashMap<String, String> data = new HashMap<>();
        Boolean userExists = userService.exists(userData.getEmail());

        if (userExists == true) {
            data.put("success", "false");
            data.put("message", "User already exists");
            return new ResponseEntity<Object>(data, HttpStatus.BAD_REQUEST);
        }

        userService.create(userData);

        data.put("success", "true");
        data.put("message", "Registered Successfully");
        return new ResponseEntity<Object>(data, HttpStatus.OK);
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