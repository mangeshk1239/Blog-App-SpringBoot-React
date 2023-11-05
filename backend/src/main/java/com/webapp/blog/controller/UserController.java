package com.webapp.blog.controller;

import java.util.HashMap;
import java.util.List;

import javax.print.attribute.standard.MediaTray;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
}