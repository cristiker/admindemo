package com.cristik.common.exception;

/**
 * Created by zhenghua on 2016/3/18.
 */
public class BusinessException extends Exception{

    public static final int NOt_LOGIN = 100;

    public static final int TOKEN_INVALID = 101;

    public static final int TOKEN_EXP_TIME = 102;

    /*public static final int*/

    String msg = "";

    String code = "";

    public BusinessException(){

    }

    public BusinessException(String msg){
        this.msg=msg;
    }

    public BusinessException(String msg,String code){
        this.msg=msg;
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
