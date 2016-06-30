package com.cristik.modules.api.action;

import com.cristik.modules.test.entity.svo.Header;
import com.cristik.modules.test.entity.svo.Image;
import com.cristik.modules.test.service.IHeaderService;
import com.cristik.modules.test.service.IImageService;
import com.cristik.common.base.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by zhenghua on 2016/5/23.
 */
@Controller
@RequestMapping("/api/v1")
public class ImageAction extends BaseAction {

    @Autowired
    IHeaderService headerService;

    @Autowired
    IImageService imageService;

    @ResponseBody
    @RequestMapping(value="/headimage")
    public String getHeadImage(){
        Header header = headerService.getHeader();

        return success("success",header.getHeadImg());
    }

    @RequestMapping("/image/{id}")
    public String getImage(@PathVariable Integer id, HttpServletResponse response){
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
