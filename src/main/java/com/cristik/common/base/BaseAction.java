package com.cristik.common.base;

import java.util.List;
import java.util.Map;

/**
 * Created by zhenghua on 2016/3/18.
 */
public class BaseAction {
    public String success(String msg){
        JSONResult jsonResult = new JSONResult(true,msg,StatusCode.SUCCESS);
        return jsonResult.toString();
    }

    public String success(String msg,Object obj){
        JSONResult jsonResult = new JSONResult(true,msg,StatusCode.SUCCESS);
        Map map = jsonResult.getData();
        if(obj instanceof List){
            map.put("list",obj);
        }else{
            map.put("obj",obj);
        }
        return jsonResult.toString();
    }

    public String success(String msg,Object obj,List list){
        JSONResult jsonResult = new JSONResult(true,msg,StatusCode.SUCCESS);
        Map map = jsonResult.getData();
        map.put("list",list);
        map.put("obj",obj);
        return jsonResult.toString();
    }

    /**
     * 普通错误提示
     * @param msg
     * @return
     */
    public String error(String msg){
        JSONResult jsonResult = new JSONResult(false,msg,StatusCode.COMMON_FAIL);
        return jsonResult.toString();
    }

    /**
     * 特定错误提示
     * @param msg
     * @param status
     * @return
     */
    public String error(String msg,Integer status){
        JSONResult jsonResult = new JSONResult(false,msg,status);
        return jsonResult.toString();
    }

}
