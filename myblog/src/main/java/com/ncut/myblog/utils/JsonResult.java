package com.ncut.myblog.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class JsonResult<E> implements Serializable {

    //总记录条数
    private Integer counts;

    //状态码
    private Integer state;
    //状态码描述信息
    private String message;

    //响应的数据，因为不确定，所以要使用泛型E
    private E data;

    //只响应 一个状态码
    public JsonResult(Integer state) {
        this.state = state;
    }
    //响应状态码+数据
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    /**
     * 状态码+统计总条数+data
     * @param counts
     * @param state
     * @param data
     */
    public JsonResult(Integer counts, Integer state, E data) {
        this.counts = counts;
        this.state = state;
        this.data = data;
    }

    //将后台的异常 传递给 响应结果集的message,   进而传递到前端    秒
    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }

}
