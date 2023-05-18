package com.ncut.myblog.service;

import com.ncut.myblog.entity.Teacher;

import java.util.List;

public interface TeacherService {

    /**
     * 查找所有教师信息
     * @return
     */
    List<Teacher> findAllTeacher();

    /**
     * 按照v排序
     * @return
     */
    List<Teacher> findVTeacher(String v);

    /**
     * 页码p , 排序方式v
     * @param p
     * @param v
     * @return
     */
    List<Teacher> findPVTeacher(Integer p,String v);

    /**
     * 统计总数
     * @return
     */
    Integer countTeachers();

}
