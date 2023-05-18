package com.ncut.myblog.mapper;

import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.entity.User;

import java.util.Date;
import java.util.List;

public interface PostUserMapper {

    /**
     * 通过编号yid，查找
     * @param yid
     * @return
     */
    PostUser findByYid(Integer yid);

    /**
     * 查找到研究生表中 所有的数据
     * @return
     */
    List<PostUser> findAllPostUser();

    /**
     * 分页
     * @return
     */
    List<PostUser> findPagePostUser(Integer page);

    /**
     * 排序加分页
     * @param page
     * @return
     */
    List<PostUser> findPageVPostUser(String v,Integer page);

    /**
     * 通过 yid 修改个人信息
     * @param yid
     * @param id
     * @param name
     * @param gender
     * @param city
     * @param career
     * @param phone
     * @param email
     * @return
     */
    Integer updatePostUser(String id,String name,Integer gender,String city,String career,String phone,String email,Integer yid);

    /**
     * 插入研究生信息
     * @param postUser
     * @return
     */
    Integer insertPostUser(PostUser postUser);

    /**
     * 根据yid删除一条记录
     * @param yid
     * @return
     */
    Integer deletePostUser(Integer yid);

    /**
     * 排序方式
     * @return
     */
    List<PostUser> findSortPostUsers(String v);

    /**
     * 搜索框， 也有同名的学生
     * @param search
     * @return
     */
    List<PostUser> searchPostUser(String search);

    /**
     * 统计研究生总数
     * @return
     */
    Integer countpostusers();
}
