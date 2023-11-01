package com.webapp.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.blog.model.User;
import com.webapp.blog.service.UserService;

@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired UserService userService;

    // @GetMapping("/get")
    // List<User> fetch() {
    //     return userService.getAllUsers();
    // }

}
