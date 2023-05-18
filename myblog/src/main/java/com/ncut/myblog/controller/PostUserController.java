package com.ncut.myblog.controller;


import com.ncut.myblog.entity.PostUser;
import com.ncut.myblog.service.PostUserService;
import com.ncut.myblog.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/postusers")
public class PostUserController extends BaseController{

    @Autowired
    private PostUserService postUserService;

    //查找到所有 研究生列表信息+数据总条数
    @RequestMapping("/all_postuser")
    public JsonResult<List<PostUser>> findAllPostuser(){
        List<PostUser> data = postUserService.getAllPostUser();
        Integer counts = postUserService.countpostuser();
        return new JsonResult<>(counts,ok,data);
    }

    @RequestMapping("/{page}/page_postuser")
    public JsonResult<List<PostUser>> PagePostuser(@PathVariable("page") Integer page){
        List<PostUser> data = postUserService.getPagePostUser(page);
        Integer counts = postUserService.countpostuser();
        return new JsonResult<>(counts,ok,data);
    }

    //分页查找 研究生列表信息+数据总条数
//    @RequestMapping("/{v}/{page}/pagev_postuser")
    @RequestMapping("/pagev_postuser")
    public JsonResult<List<PostUser>> findPagePostuser(String v,Integer page){
//        List<PostUser> data = postUserService.getPagePostUser(page);
        List<PostUser> data = postUserService.getPageVPostUser(v,page);
        Integer counts = postUserService.countpostuser();
        return new JsonResult<>(counts,ok,data);
    }

    @RequestMapping("/{yid}/getByYid")
    public JsonResult<PostUser> getByYid(@PathVariable("yid") Integer yid){
        PostUser data = postUserService.findByYid(yid);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("/change_postuser")
    public JsonResult<Void> changeByYid(PostUser postUser){
        postUserService.changePostUser(postUser.getId(),
                                        postUser.getName(),
                                        postUser.getGender(),
                                        postUser.getCity(),
                                        postUser.getCareer(),
                                        postUser.getPhone(),
                                        postUser.getEmail(),
                                        postUser.getYid());
        return new JsonResult<>(ok);
    }

    @RequestMapping("/add_postuser")
    public JsonResult<Void> add_postuser(PostUser postUser){
        //前端传入的postuser对象，不包含yid主键
        postUserService.addPostUser(postUser);
        return new JsonResult<>(ok);
    }

    @RequestMapping("/{yid}/delete_postuser")
    public JsonResult<Void> delete_postuser(@PathVariable("yid") Integer yid){
        postUserService.deletePostUser(yid);
        return new JsonResult<>(ok);
    }

    @RequestMapping("/{v}/sort_postusers")
    public JsonResult<List<PostUser>> findSortPostuser(@PathVariable("v") String v) {
        List<PostUser> data = postUserService.findSortPostUsers(v);
        return new JsonResult<>(ok, data);
    }


    @RequestMapping("/{search}/search_postusers")
    public JsonResult<List<PostUser>> searchPostuser(@PathVariable("search") String name){
        List<PostUser> data = postUserService.searchPostUsers(name);
        return new JsonResult<>(ok,data);
    }
}
