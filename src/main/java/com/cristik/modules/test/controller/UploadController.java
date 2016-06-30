package com.cristik.modules.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by zhenghua on 2016/3/24.
 */
@Controller
@RequestMapping("/file")
public class UploadController {

    /**
     * 跳转到文件上传页面
     * @return
     */
    @RequestMapping("touploadfile")
    public String toUpLoadFile(){
        return "file/fileupload";
    }


    /**
     * 自己方式上传文件
     * @param files
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("file") CommonsMultipartFile[] files, HttpServletRequest request){
        for(CommonsMultipartFile file : files){
            System.out.println("fileName---------->" + file.getOriginalFilename());

            if(!file.isEmpty()){
                int pre = (int) System.currentTimeMillis();
                try {
                    //拿到输出流，同时重命名上传的文件
                    FileOutputStream os = new FileOutputStream("D:/" + new Date().getTime() + file.getOriginalFilename());
                    //拿到上传文件的输入流
                    InputStream in = file.getInputStream();
                    /*FileInputStream in = (FileInputStream) file.getInputStream();*/
                    //以写字节的方式写文件
                    int b = 0;
                    while((b=in.read()) != -1){
                        os.write(b);
                    }
                    os.flush();
                    os.close();
                    in.close();
                    int finaltime = (int) System.currentTimeMillis();
                    System.out.println(finaltime - pre);

                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("上传出错");
                }
            }
        }
        return "/success";
    }

    /**
     * 包装方式上传文件
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload2")
    public String upload2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim() !=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String path = "D:/" + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                System.out.println(finaltime - pre);
            }
        }*/
        return "";
    }



}
