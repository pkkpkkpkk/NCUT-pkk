package com.ncut.myblog.controller;

import com.ncut.myblog.entity.User;
import com.ncut.myblog.service.UserService;
import com.ncut.myblog.utils.JsonResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<>(ok); //OK = 200 在BaseController中
    }
//    前端访问请求，把username 和 password 封装到user对象中 传入到 这里的参数User user 中
    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session){ //前端可以传过来 user对象，也可以传过来username = ? passowrd=？
        //在控制层，登录成功后，将username 和password 保存到session 中
        User data = userService.login(username, password);
//        data(uid,username,password)  将uid ， username放到session中，为了以后使用
//        返回的数据是为了辅助其他页面做数据展示使用
        session.setAttribute("uid",data.getUid());
        session.setAttribute("username",data.getUsername());

        return new JsonResult<>(200,data);
    }

    @RequestMapping("/detail")
    public JsonResult<User> findDetail(HttpSession session){
        //从session中拿到uid
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        User data = userService.findDetail(uid);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("/change_password")
    public JsonResult<Void> changePassword(String oldPassword,String newPassword,HttpSession session){
        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        userService.change_password(oldPassword,newPassword,uid);
        return new JsonResult<>(ok);
    }
    @RequestMapping("/change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
//        前端传过来的参数(email,telephone,gender)自动封装到User user对象中
//String email,String telephone,String hobby,String gender,String isAdmin,String signature,Integer uid
        String email = user.getEmail();
        String telephone = user.getTelephone();
        String hobby = user.getHobby();
        String gender = user.getGender();
        String isAdmin = user.getIsAdmin();
        String signature = user.getSignature();

        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
        userService.change_info(email,telephone,hobby,gender,isAdmin,signature,uid);
        return new JsonResult<>(ok);
    }

    @RequestMapping("/logout")
    public JsonResult<Void> logout(HttpServletRequest request){
        //清理Session中保存的当前登录员工的uid,username
        request.getSession().removeAttribute("uid");
        request.getSession().removeAttribute("username");
        return new JsonResult<>(ok);
    }
}