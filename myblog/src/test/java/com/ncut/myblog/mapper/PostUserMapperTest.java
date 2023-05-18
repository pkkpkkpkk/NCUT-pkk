package com.ncut.myblog.mapper;


import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostUserMapperTest {

    @Autowired
    private PostUserMapper postUserMapper;

    @Test
    public void findAllPostUser(){
        List<PostUser> allPostUser = postUserMapper.findAllPostUser();
        System.out.println(allPostUser);
    }
    @Test
    public void findPagePostUser(){
        List<PostUser> allPostUser = postUserMapper.findPagePostUser(0);
        System.out.println(allPostUser);
    }

    @Test
    public void findPageVPostUser(){
        List<PostUser> allPostUser = postUserMapper.findPageVPostUser("id",2);
        System.out.println(allPostUser);
    }

    @Test
    public void findSortPostUser(){
        List<PostUser> PostUser = postUserMapper.findSortPostUsers("id");
        for (int i = 0; i < 5; i++) {
            System.out.println(PostUser.get(i));
        }
    }

    @Test
    public void countpostuser(){
        Integer counts = postUserMapper.countpostusers();
        System.out.println("总数："+counts);
    }

}
