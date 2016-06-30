package com.cristik.modules.test.controller;

import com.cristik.modules.test.service.IDictionarysService;
import com.cristik.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zhenghua on 2016/3/11.
 */

@Controller
@RequestMapping("/main")
public class MainController extends BaseController{
    @Autowired
    IDictionarysService dictionarysService;

    @Autowired
    RedisTemplate<String,String> redisTemplate1;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    @RequestMapping("/")
    public String index(){
        System.out.println("here is the welcome page");
        System.out.println(111);
        return "index";
    }

    @ResponseBody
    @RequestMapping("testint")
    public String testInt(@RequestParam(defaultValue = "0")int id){
        System.out.println(id);
        return error("错误");
    }

    @RequestMapping("/test")
    public String test(){
        return "test/test";
    }

    @RequestMapping(value = "/pets/{petId}", method = RequestMethod.GET)
    public void findPet(@PathVariable String petId, @MatrixVariable int q) {
        System.out.println("petId="+petId+",q="+q);
    }

    @RequestMapping("/testcache")
    @ResponseBody
    public String testCache(){
        //dictionarysService.loadCaches();
        listOps.leftPush("1","2","3");
        // or use template directly
        redisTemplate1.boundListOps("11").leftPush("22");
        redisTemplate1.keys("11");

        return success("缓存成功");
    }
}
