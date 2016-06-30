package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.ImageDao;
import com.cristik.modules.test.entity.svo.Image;
import com.cristik.modules.test.service.IImageService;
import com.cristik.common.utils.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhenghua on 2016/3/24.
 */

@Transactional
@Service
public class ImageServiceImpl implements IImageService{

    @Autowired
    ImageDao imageDao;

    /**
     * 根据图片id获取图片信息
     * @param id
     * @return
     */
    @Override
    public Image getImageById(Integer id) {
        Image image = new Image();
        image.setId(id);
        image = imageDao.selectOne(image);
        return image;
    }

    /**
     * 删除图片
     * @param id
     * @return
     */
    @Override
    public boolean deleteImageById(Integer id) {
        Image image = new Image();
        image.setId(id);
        image = imageDao.selectOne(image);
        boolean flag = deleteFile(image.getPicLocation());
        if(flag){
            int num = imageDao.deleteByPrimaryKey(id);
            if(num==1){
                return true;
            }
        }
        return false;
    }

    /**
     * 图片保存
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    public String saveImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        StringBuffer sb = new StringBuffer() ;
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            List<Image> images = saveImageByRequest(multiRequest);
            for(int i=0;i<images.size();i++){
                sb.append(images.get(i).getId());
                if(i!=images.size()-1){
                    sb.append("#");
                }
            }
        }
        return sb.toString();
    }

    /**
     * 遍历文件上传请求取得所有文件
     * @param multiRequest
     * @return
     * @throws IOException
     */
    private List<Image> saveImageByRequest(MultipartHttpServletRequest multiRequest) throws IOException {
        Iterator<String> iter = multiRequest.getFileNames();
        List<Image> images = new ArrayList<Image>();
        while(iter.hasNext()){
            //取得上传文件
            MultipartFile file = multiRequest.getFile(iter.next());
            if(file != null){
                Image image = saveImageLocation(file);
                images.add(image);
            }
        }
        return images;
    }

    /**
     * 将单张图片存储到磁盘上并插入数据库信息
     * @param multipartFile
     * @return
     * @throws IOException
     */
    private Image saveImageLocation(MultipartFile multipartFile) throws IOException {
        //取得当前上传文件的文件名称
        String fileName = multipartFile.getOriginalFilename();
        Image image = new Image();
        //如果名称不为"",说明该文件存在，否则说明该文件不存在
        if(fileName.trim() !=""){
            //重命名上传后的文件名
            String newName = IdUtil.getId()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
            //定义上传路径
            String path = "D:/pic/" + newName;
            File localFile = new File(path);
            multipartFile.transferTo(localFile);

            image.setPicLocation(path);
            image.setPicName(fileName);
            image.setCreateTime(new Date());
            image.setUpdateTime(new Date());
            imageDao.insert(image);
        }
        return image;
    }

    /**
     * 根据存储地址删除磁盘图片
     * @param filePath
     * @return
     */
    private boolean deleteFile(String filePath){
        File file = new File(filePath);
        boolean flag = file.delete();
        return flag;
    }

}
