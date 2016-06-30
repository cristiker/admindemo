package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhenghua on 2016/4/20.
 */
public interface IImageService {

    Image getImageById(Integer id);

    String saveImage(HttpServletRequest request, HttpServletResponse response) throws IOException;

    boolean deleteImageById(Integer id);


}
