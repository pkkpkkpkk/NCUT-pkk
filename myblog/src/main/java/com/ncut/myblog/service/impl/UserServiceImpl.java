package com.ncut.myblog.service.impl;

import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.User;
import com.ncut.myblog.service.ex.*;
import com.ncut.myblog.mapper.UserMapper;
import com.ncut.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user){
            String username = user.getUsername();
            String password = user.getPassword();

            User result = userMapper.findByUsername(username);
            if (result != null){
                throw new UsernameDuplicateException("用户名已存在");
            }
            Date date = new Date();

            user.setUsername(username);
            user.setPassword(password);
            user.setCreatedTime(date);

            Integer rows = userMapper.insert(user);
            if (rows != 1){
                throw new InsertException("插入数据时产生未知的异常");
            }
//            System.out.println("注册成功");

        }

    @Override
    public User login(String username, String password) {

        User result = userMapper.findByUsername(username);
        if (result == null){
            throw new UserNotFoundException();
        }
        if (!result.getPassword().equals(password)){
            throw new PasswordNotMatchException("密码输入不正确");
        }
        //密码输入正确，将username,password打包放到user对象中返回
        User user = new User();
        user.setUid(result.getUid()); //从 result中拿
        user.setUsername(result.getUsername());
        user.setPassword(result.getPassword());
//        user(uid,username,password)
        return user;
    }

    @Override
    public User findDetail(Integer uid) {
        User user = userMapper.findByUid(uid);
        return user;
    }

    @Override
    public void change_password(String oldPassword, String newPassword, Integer uid) {

        User result = userMapper.findByUid(uid);
        if (!(result.getPassword().equals(oldPassword))){
            throw new PasswordNotCorrectException("旧密码输入不正确");
        }
        userMapper.updatePassword(newPassword,new Date(),uid);
    }

    @Override
    public void change_info(String email,String telephone,String hobby,String gender,String isAdmin,String signature,Integer uid) {

        Integer rows = userMapper.updateInfo(email, telephone,hobby, gender,isAdmin,signature, new Date(), uid);
        if (rows != 1){
            throw new UpdateInfoException("更新时产生的异常");
        }
    }

}
