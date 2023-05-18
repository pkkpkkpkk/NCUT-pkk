package com.ncut.myblog.service;


import com.ncut.myblog.entity.PostUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostUserServiceTest {

    @Autowired
    private PostUserService postUserService;

    @Test
    public void findPagePostuser(){
        List<PostUser> allPagePostuser = postUserService.getPagePostUser(1);
        System.out.println(allPagePostuser);
    }

    @Test
    public void findPageVPostuser(){
        List<PostUser> allPagePostuser = postUserService.getPageVPostUser("id",2);
        System.out.println(allPagePostuser);
    }

    @Test
    public void searchPostuser(){
        List<PostUser> list = postUserService.searchPostUsers("123"); //name不存在
//       查不到的话返回一个空列表 []

        System.out.println( list==null );   //false
        if (list == null || list.size() == 0){ //列表为空
            System.out.println("列表为空");
        }else {
            System.out.println(list);
        }

    }
}
