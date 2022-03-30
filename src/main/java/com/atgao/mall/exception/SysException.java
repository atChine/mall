package com.atgao.mall.exception;

import com.atgao.mall.enums.AppHttpCodeEnum;

public class SysException extends RuntimeException{
   private int code;
   private String msg;

    public int getCode() {
        return code;
    }

    public String getMas() {
        return msg;
    }


    public SysException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }
}
