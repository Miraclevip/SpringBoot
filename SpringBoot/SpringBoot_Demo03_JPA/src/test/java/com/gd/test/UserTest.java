package com.gd.test;

import com.gd.SpringbootJpaApplication;
import com.gd.dao.UserRepository;
import com.gd.daomain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll(){
        List<User> userList = userRepository.findAll();
        System.out.println(userList);
    }
}
