package com.cristik.common.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhenghua on 2016/3/24.
 */
public class PropertiesUtil {

    public static String getProperty(String fileName,String key) throws IOException {
        String path = "";
        Properties properties = new Properties();
        URL url = PropertiesUtil.class.getClassLoader().getResource(fileName);
        if(url!=null){
            path = url.getPath();
            FileInputStream in = new FileInputStream(path);
            properties.load(in);
            String value = properties.getProperty(key);
            return value;
        }else{
            path = PropertiesUtil.class.getClassLoader().getResource("").getPath();
            List<File> files = FileUtil.searchFile(new File(path),fileName);
            if(files.size()==1){
                properties.load(new FileInputStream(files.get(0)));
                String value = properties.getProperty(key);
                return value;
            }else{
                return "";
            }
        }
    }

}
