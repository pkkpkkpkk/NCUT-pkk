package com.ncut.myblog.service;

import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface UserService {

    /**
     * 用户注册
     */
    void reg(User user);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return 当登录成功后需要获取该用户的id，即uid，方便以后使用
     */
    User login(String username,String password);

    /**
     * 根据uid查找 个人信息
     * @param uid
     * @return
     */
    User findDetail(Integer uid);

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @param uid
     */
    void change_password(String oldPassword,String newPassword,Integer uid);

    /**
     * 修改用户信息
     * @param email
     * @param telephone
     * @param hobby
     * @param isAdmin
     * @param signature
     * @param gender
     * @param uid
     */
    void change_info(String email,String telephone,String hobby,String gender,String isAdmin,String signature,Integer uid);


}
