package com.webapp.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @Autowired UserService userService;

    @PostMapping("/create")
    public Boolean createUser(@RequestBody String reqBody) {
        try {
            System.out.println(reqBody);
            return true;
        } catch (Exception e) {
            System.out.println("ERROR");
            return false;
        }
    }   
}