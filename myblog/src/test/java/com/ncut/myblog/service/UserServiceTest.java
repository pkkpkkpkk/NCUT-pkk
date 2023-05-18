package com.ncut.myblog.service;


import com.ncut.myblog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void UserServiceTest(){
        User user = new User();
        user.setUsername("ycp");
        user.setPassword("ycp");
        userService.reg(user);
    }

    @Test
    public void login(){
        User user = userService.login("123", "123");
        System.out.println(user);
    }

    @Test
    public void findDetail(){
        User user = userService.findDetail(18);
        System.out.println(user);
    }

    @Test
    public void updatePassword(){
        userService.change_password("123","456",17);
    }
}
