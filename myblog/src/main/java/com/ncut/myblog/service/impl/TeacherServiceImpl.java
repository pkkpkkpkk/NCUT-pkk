package com.ncut.myblog.service.impl;

import com.ncut.myblog.entity.Teacher;
import com.ncut.myblog.mapper.TeacherMapper;
import com.ncut.myblog.service.TeacherService;
import com.ncut.myblog.service.ex.DataNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAllTeacher() {
        List<Teacher> allTeacher = teacherMapper.findAllTeacher();
        if (allTeacher == null || allTeacher.size() ==0){
            throw new DataNullException("数据库信息为空");
        }
        return allTeacher;
    }

    @Override
    public List<Teacher> findVTeacher(String v) {

        List<Teacher> vTeacher = teacherMapper.findVTeacher(v);
        if (vTeacher == null || vTeacher.size() ==0){
            throw new DataNullException("数据库信息为空");
        }
        return vTeacher;
    }

    @Override
    public List<Teacher> findPVTeacher(Integer p, String v) {
        Integer page = (p-1)*10;
        List<Teacher> pvTeacher = teacherMapper.findPVTeacher(page, v);
        if (pvTeacher == null || pvTeacher.size()==0){
            throw new DataNullException("数据库信息为空");
        }
        return pvTeacher;
    }

    @Override
    public Integer countTeachers() {
        Integer counts = teacherMapper.countTeachers();
        return counts;
    }
}
