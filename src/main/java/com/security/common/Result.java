package com.security.common;

import lombok.Data;

@Data
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的内容
     */
    private T data;


    public Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result setData(T data){
        this.data = data;
        return this;
    }

    public Result setMsg(String msg){
        this.msg = msg;
        return this;
    }

    public static Result getSuccess(){
        return new Result(200,"成功");
    }

    public static Result getFailure(){
        return new Result(400,"失败");

    }
}
