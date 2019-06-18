package com.gd.test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.gd.SpringbootRedisApplication;
import com.gd.dao.UserRepository;
import com.gd.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootRedisApplication.class)
public class UserTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll(){
        String usersJson = redisTemplate.boundValueOps("userFindAll").get();
        if(null == usersJson){
            List<User> userList = userRepository.findAll();

            //转换成json格式字符串
            usersJson = String.valueOf(userList);

            //转换成json格式字符串
            /*
            ObjectMapper om = new ObjectMapper();
            usersJson = om.writeValueAsString(userList);
            */
            redisTemplate.boundValueOps("userFindAll").set(usersJson);
            System.out.println(userList);
            System.out.println("从数据库中查找");
        }else {
            System.out.println("从redis中查找");
        }
        System.out.println(usersJson);

    }
}
