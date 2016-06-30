package com.cristik.modules.test.controller;

import com.cristik.modules.test.entity.svo.Image;
import com.cristik.modules.test.service.IImageService;
import com.cristik.common.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by zhenghua on 2016/5/11.
 */
@Controller
@RequestMapping("/image")
public class ImageController extends BaseController {

    @Autowired
    IImageService imageService;

    @ResponseBody
    @RequestMapping("/save")
    public String save(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String ids = imageService.saveImage(request,response);
        return success("图片保存成功",ids);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String deleteImage(HttpServletRequest request,Integer key){
        Map map = request.getParameterMap();
        boolean flag = imageService.deleteImageById(key);
        if(flag){
            return success("删除成功");
        }
        return error("删除失败");
    }


    @RequestMapping("/view/{id}")
    public String viewImage(@PathVariable Integer id, HttpServletResponse response){
        FileInputStream fis = null;
        response.setContentType("image/gif");
        Image image = imageService.getImageById(id);
        File file = new File("");
        try {
            OutputStream out = response.getOutputStream();
            if(image!=null&&image.getPicLocation()!=null&&image.getPicLocation()!=""){
                file = new File(image.getPicLocation());
            }
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
