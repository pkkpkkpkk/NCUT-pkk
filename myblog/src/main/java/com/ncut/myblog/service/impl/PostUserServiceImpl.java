package com.ncut.myblog.service.impl;

import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.mapper.PostUserMapper;
import com.ncut.myblog.service.PostUserService;
import com.ncut.myblog.service.ex.DataNullException;
import com.ncut.myblog.service.ex.DeleteException;
import com.ncut.myblog.service.ex.InsertException;
import com.ncut.myblog.service.ex.UpdateInfoException;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostUserServiceImpl implements PostUserService {

    @Autowired
    private PostUserMapper postUserMapper;

    @Override
    public List<PostUser> getAllPostUser() {
        List<PostUser> allPostUser = postUserMapper.findAllPostUser();
        if (allPostUser == null){
            throw new DataNullException("数据库信息为空");
        }
        return allPostUser;
    }

    @Override
    public List<PostUser> getPagePostUser(Integer page) {
//        分页数据处理在后端service层处理 limit   (pageNo-1)*pageSize ,pageSize
        page = (page - 1) * 10;
        List<PostUser> pagePostUser = postUserMapper.findPagePostUser(page);
        if (pagePostUser == null){
            throw new DataNullException("数据库信息为空");
        }
        return pagePostUser;
    }

    @Override
    public List<PostUser> getPageVPostUser(String v,Integer page) {
//        System.out.println("v:"+v);
        page = (page - 1) * 10;
//        排序方式v为空，则默认 按学号升序，并分页
        if (v == ""){
            List<PostUser> result1 = postUserMapper.findPagePostUser(page);
            return result1;
        }else {
            //排序方式v不空，则按照v升序，并分页
            List<PostUser> result2 = postUserMapper.findPageVPostUser(v,page);
            return result2;
        }
    }

    @Override
    public PostUser findByYid(Integer yid) {
        PostUser postUser = postUserMapper.findByYid(yid);
        if (postUser == null){
            throw new DataNullException("数据不存在异常");
        }
        return postUser;
    }

    @Override
    public Integer changePostUser(String id, String name, Integer gender, String city, String career, String phone, String email, Integer yid) {
        Integer row = postUserMapper.updatePostUser(id, name, gender, city, career, phone, email, yid);
        if (row != 1){
            throw new UpdateInfoException("更新信息失败");
        }
        return null;
    }

    @Override
    public Integer addPostUser(PostUser postUser) {
//        这里的 postUser 对象是 controller从前端拿到的，  不含yid的PostUser对象
//        执行mapper层插入函数是，会将前端拿到的postuser对象中的 已存在的属性，对号入座。 前端不用传yid
        Integer row = postUserMapper.insertPostUser(postUser);
        if (row !=1 ){
            throw new InsertException("插入数据时产生的异常");
        }
        return null;
    }

    @Override
    public Integer deletePostUser(Integer yid) {
        Integer row = postUserMapper.deletePostUser(yid);
        if (row != 1){
            throw new DeleteException("删除数据时产生的异常");
        }
        return null;
    }

    @Override
    public List<PostUser> findSortPostUsers(String v) {
        List<PostUser> sortPostUsers = postUserMapper.findSortPostUsers(v);
        if (sortPostUsers == null || sortPostUsers.size() ==0){
            throw new DataNullException("数据库信息为空");
        }
        return sortPostUsers;
    }

    @Override
    public List<PostUser> searchPostUsers(String name) {
        List<PostUser> postUsers = postUserMapper.searchPostUser(name);
        if (postUsers == null || postUsers.size() == 0){
            throw new DataNullException("数据库信息为空");
        }
        return postUsers;
    }

    @Override
    public Integer countpostuser() {
        Integer counts = postUserMapper.countpostusers();
        return counts;
    }

}
