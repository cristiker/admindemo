package com.cristik.common.base;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhenghua on 2016/3/21.
 */
public class Result {

    private boolean success;

    private String status;

    private String msg;

    private String url;

    private HashMap<String,Object> data = new HashMap<String, Object>();

    private List<Object> list = new ArrayList<Object>();

    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String msg) {
        this(success);
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }

    public void setList(List<Object> list){
        this.list = list;
    }

    public void put(String key, Object obj){
        data.put(key,obj);
    }

    @Override
    public String toString() {
        data.put("list",this.list);
        String json = JSON.toJSON(this).toString();
        return json;
    }
}
