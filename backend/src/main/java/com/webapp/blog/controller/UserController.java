package com.webapp.blog.controller;

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

    @PostMapping(value = "/create", produces = { "application/json" })
    // public Boolean createUser(@RequestBody String reqBody) {
    // try {
    // userService.create(reqBody);
    // return true;
    // } catch (Exception e) {
    // System.out.println("ERROR");
    // return false;
    // }
    // }
    public ResponseEntity createUser(@RequestBody User userData) {

        userService.create(userData);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}