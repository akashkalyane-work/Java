package com.example.userApi.controller;

import com.example.userApi.entity.User;
import com.example.userApi.entity.UserDetail;
import com.example.userApi.repository.UserDetailRepository;
import com.example.userApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @GetMapping
    public String getUsers(){
        User user = userRepository.findById(1).orElse(null);
        UserDetail userDetail = new UserDetail(0, "test2", "tested2", "1234567890", user);
        userDetailRepository.save(userDetail);
        return "user list!";
    }
}
