package com.ncut.myblog.mapper;


import com.ncut.myblog.entity.Teacher;

import java.util.List;

public interface TeacherMapper {

    /**
     * 查找到老师表中 所有的数据
     * @return
     */
    List<Teacher> findAllTeacher();

    /**
     * 按照v排序
     * @param v
     * @return
     */
    List<Teacher> findVTeacher(String v);

    /**
     * p页面，v排序方式
     * @param p
     * @param v
     * @return
     */
    List<Teacher> findPVTeacher(Integer p,String v);

    /**
     * 统计老师总数
     * @return
     */
    Integer countTeachers();
}
