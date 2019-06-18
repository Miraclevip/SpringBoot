package com.gd.controller;

import com.gd.dao.UserMapper;
import com.gd.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> userList = userMapper.findAll();
        return userList;
    }
}
