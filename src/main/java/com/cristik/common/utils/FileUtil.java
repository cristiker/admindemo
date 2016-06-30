package com.cristik.common.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghua on 2016/3/24.
 */
public class FileUtil {

    private static ThreadLocal<List<File>> fileSet = new ThreadLocal<List<File>>(){
        @Override
        protected List<File> initialValue() {
            return new ArrayList<File>();
        }
    };

    public static List<File> serarhFilesByName(String path,String fileName) {
        List<File> files = new ArrayList<File>();
        File file = new File(path);
        getAllFiles(file);
        if(fileSet.get().size()>0){
            for(File e : fileSet.get()){
                if(fileName.equals(e.getName())){
                    files.add(e);
                }
            }
        }
        return files;
    }

    public static void getAllFiles(File dir){
        File[] fs = dir.listFiles();
        for(File file : fs){
            if(file.isDirectory()){
                getAllFiles(file);
            }else{
                fileSet.get().add(file);
            }
        }
    }


    /**
     * 递归查找含关键字的文件
     * @param folder
     * @param keyWord
     * @return
     */
    public static List<File> searchFile(File folder, final String keyWord) {
        // 运用内部匿名类获得文件
        File[] subFolders = folder.listFiles(new FileFilter() {
            // 实现FileFilter类的accept方法
            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile())
                    System.out.println("文件");
                else
                    // 如果是目录
                    System.out.println("文件夹");
                if (pathname.isDirectory()||(pathname.isFile() && pathname.getName().toLowerCase().contains(keyWord.toLowerCase())))
                    return true;
                return false;
            }
        });
        List<File> result = new ArrayList<File>();
        for (int i = 0; i < subFolders.length; i++) {
            if (subFolders[i].isFile()) {
                result.add(subFolders[i]);
            } else {
                List<File> foldResult = searchFile(subFolders[i], keyWord);
                for (File file: foldResult) {
                    result.add(file);
                }
            }
        }
        return result;
    }

}
