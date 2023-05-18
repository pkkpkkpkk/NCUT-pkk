package com.ncut.myblog.service;

import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.User;

import java.util.List;

public interface PostUserService {
    /**
     * 得到研究生表中 所有数据
     * @return
     */
    List<PostUser> getAllPostUser();

    /**
     * 分页查询
     * @return
     */
    List<PostUser> getPagePostUser(Integer page);

    /**
     *  分页+排序
     * @param page 分页
     * @param v 排序
     * @return
     */
    List<PostUser> getPageVPostUser(String v,Integer page);
    /**
     * 通过yid查找信息
     * @param yid
     * @return
     */
    PostUser findByYid(Integer yid);

    /**
     * 修改研究生信息
     * @param id
     * @param name
     * @param gender
     * @param city
     * @param career
     * @param phone
     * @param email
     * @param yid
     * @return
     */
    Integer changePostUser(String id,String name,Integer gender,String city,String career,String phone,String email,Integer yid);

    /**
     * 添加研究生信息数据
     * @param postUser
     * @return
     */
    Integer addPostUser(PostUser postUser);

    /**
     * 删除研究生信息数据
     * @param yid
     * @return
     */
    Integer deletePostUser(Integer yid);

    /**
     * 排序方式
     * @param v
     * @return
     */
    List<PostUser> findSortPostUsers(String v);

    /**
     * 根据name查
     * @param name
     * @return
     */
    List<PostUser> searchPostUsers(String name);

    /**
     * 统计 总数
     * @return
     */
    Integer countpostuser();

}
