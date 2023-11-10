package com.webapp.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.blog.model.User;
import com.webapp.blog.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean exists(String userEmail) {
        return userRepository.exists(userEmail);
    }

    public Boolean valid(String userPassword) {
        return userRepository.valid(userPassword);
    }

    public Boolean create(User userData) {
        userRepository.create(userData);
        return true;
    }

    public List<User> find(long id) {
        return userRepository.findById(id);
    }
}
