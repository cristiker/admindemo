package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.test.Signature;
import com.cristik.modules.test.service.ISignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhenghua on 2016/3/30.
 */
@Controller
@RequestMapping("/signature")
public class SignatureController {
    @Autowired
    ISignatureService signatureService;


    @RequestMapping("/test")
    public String toTest(){
        return "test/signature";
    }

    @RequestMapping("/insert")
    public String insert(Signature signature){
        int id = signatureService.insertSignature(signature);
        System.out.println(id);
        return "redirect:/signature/test";
    }



}
