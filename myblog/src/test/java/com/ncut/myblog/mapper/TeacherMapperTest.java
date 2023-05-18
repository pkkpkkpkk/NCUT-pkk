package com.ncut.myblog.mapper;


import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void findAllPostUser(){
        List<Teacher> allPostUser = teacherMapper.findAllTeacher();
        System.out.println(allPostUser);
    }

    @Test
    public void findTPostUser(){
        List<Teacher> allPostUser = teacherMapper.findVTeacher("name");
        System.out.println(allPostUser);
    }
}
