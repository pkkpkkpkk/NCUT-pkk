package com.ncut.myblog.mapper;

import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.User;

import java.util.Date;
import java.util.List;

public interface UserMapper {

    /**
     * 用户注册  插入一条数据
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 注册之前，先查找一下 注册的用户在数据库中是否存在
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 通过uid来查找用户
     * @param uid
     * @return 返回查找到的用户数据
     */
    User findByUid(Integer uid);

    /**
     * 修改密码，修改时间
     * @param password
     * @param modifiedTime
     * @param uid
     * @return
     */
    Integer updatePassword(String password, Date modifiedTime ,Integer uid);

    /**
     * 通过uid,修改个人信息，同时 修改modifiedTime
     * @param email
     * @param telephone
     * @param hobby
     * @param gender
     * @param isAdmin
     * @param signature
     * @param modifiedTime
     * @param uid
     * @return
     */
    Integer updateInfo(String email,String telephone,String hobby,String gender,String isAdmin,String signature, Date modifiedTime,Integer uid);

}
