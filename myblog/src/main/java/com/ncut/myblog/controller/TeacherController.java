package com.ncut.myblog.controller;

import com.ncut.myblog.entity.Teacher;
import com.ncut.myblog.service.TeacherService;
import com.ncut.myblog.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends BaseController{

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/all_teacher")
    public JsonResult<List<Teacher>> AllTeacher(){
        List<Teacher> data = teacherService.findAllTeacher();
        Integer counts = teacherService.countTeachers();
        return new JsonResult<>(counts,ok,data);
    }
    @RequestMapping("/{v}/v_teacher")
    public JsonResult<List<Teacher>> AllTeacher(@PathVariable("v") String v){
        List<Teacher> data = teacherService.findVTeacher(v);
        return new JsonResult<>(ok,data);
    }
    @RequestMapping("/pv_teacher")
    public JsonResult<List<Teacher>> AllTeacher(Integer p,String v){
        List<Teacher> data = teacherService.findPVTeacher(p,v);
        return new JsonResult<>(ok,data);
    }


}
