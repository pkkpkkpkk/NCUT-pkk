package com.ncut.myblog.service;


import com.ncut.myblog.entity.Teacher;
import com.ncut.myblog.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void findAllTeacher(){
        List<Teacher> allTeacher = teacherService.findAllTeacher();
        System.out.println(allTeacher);
    }

    @Test
    public void findVTeacher(){
        List<Teacher> VTeacher = teacherService.findVTeacher("姓名");
        System.out.println(VTeacher);
    }
}
