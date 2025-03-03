package com.example.WithDatabase.controller;

import com.example.WithDatabase.entity.UserDetail;
import com.example.WithDatabase.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private UserDetailRepository userDetailRespository;

//    @GetMapping()
//    public List<UserDetail> getUsers() {
//
//        List<UserDetail> data = userDetailRespository.findAll();
//        return data;
//    }
}
