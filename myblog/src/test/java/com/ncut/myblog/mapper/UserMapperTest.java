package com.ncut.myblog.mapper;


import com.ncut.myblog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void register(){
        User user = new User();
        user.setUsername("001");
        user.setPassword("001");
        Integer rows = userMapper.insert(user);
        if (rows == 1){
            System.out.println("插入数据成功");
        }

    }

    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("123");
        System.out.println(user);
    }

    @Test
    public void findByUid(){
        User user = userMapper.findByUid(18);
        System.out.println(user);
    }

    @Test
    public void updatePassword(){
        Integer rows = userMapper.updatePassword("456", new Date(),17);
        System.out.println(rows);
    }
}
