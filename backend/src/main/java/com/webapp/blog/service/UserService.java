package com.webapp.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.blog.model.User;
import com.webapp.blog.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean exists(String userEmail) {
        return userRepository.exists(userEmail);
    }

    public Boolean create(User userData) {
        userRepository.create(userData);
        return true;
    }
}
