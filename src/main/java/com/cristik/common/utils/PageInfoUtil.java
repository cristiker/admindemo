package com.cristik.common.utils;

import com.cristik.common.base.PageInfo;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by zhenghua on 2016/4/20.
 */
public class PageInfoUtil {

    public static PageInfo parse(Page page){
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotal(page.getTotal());
        pageInfo.setData(page.getResult());
        pageInfo.setTotalPage(page.getPages());
        pageInfo.setPageNum(page.getPageNum());
        pageInfo.setPageSize(page.getPageSize());
        return pageInfo;
    }

    public static PageInfo parseList(List list){
        PageInfo pageInfo = new PageInfo();
        if(list instanceof Page){
            Page page = (Page)list;
            pageInfo = parse(page);
        }
        return pageInfo;
    }

}
