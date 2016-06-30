package com.cristik.common.base;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhenghua on 2016/5/26.
 */
public class JSONResult {

    private boolean success;

    private String msg;

    private Integer status;

    private Map data = new HashMap();

    public JSONResult() {
    }

    public JSONResult( boolean success,String msg) {
        this.msg = msg;
        this.success = success;
    }

    public JSONResult(boolean success,String msg,Integer status) {
        this.msg = msg;
        this.status = status;
        this.success = success;
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        String json = JSONObject.toJSONString(this);
        return json;
    }
}
