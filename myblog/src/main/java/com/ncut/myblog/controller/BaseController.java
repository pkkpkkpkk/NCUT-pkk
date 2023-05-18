package com.ncut.myblog.controller;

import com.ncut.myblog.service.ex.*;
import com.ncut.myblog.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    //操作成功的状态码
    public static final int ok=200;
//    service层中捕获的异常都传到这个类处理。usercontroller 继承此类，所以会把消息 返回至data中
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);

        //写这个 是为了把异常信息传递给前端,
        if (e instanceof UsernameDuplicateException){
            result.setState(4000);
            result.setMessage("用户名已被占用");
        }else if (e instanceof UserNotFoundException){
            result.setState(4001);
            result.setMessage("用户名不存在");
        }else if (e instanceof PasswordNotMatchException){
            result.setState(4002);
            result.setMessage("用户名密码错误");
        }else if (e instanceof PasswordNotCorrectException){
            result.setState(4003);
            result.setMessage("旧密码输入错误");
        }else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("插入数据时产生异常");
        }else if (e instanceof UpdateInfoException){
            result.setState(5001);
            result.setMessage("更新时产生的异常");
        }else if (e instanceof DataNullException){
            result.setState(6001);
            result.setMessage("数据库信息为空");
        }else if (e instanceof  DeleteException){
            result.setState(7001);
            result.setMessage("删除时产生的异常");
        }


        return result;
    }
}
