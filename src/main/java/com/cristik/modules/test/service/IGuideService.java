package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Guide;
import com.cristik.common.base.PageInfo;

/**
 * Created by zhenghua on 2016/5/5.
 */
public interface IGuideService {

    PageInfo queryPage(PageInfo pageInfo);//分页查询数据

    Guide getGuideById(Integer id);//根据id查询详情

    boolean lock(Integer id);//禁用

    boolean unLock(Integer id);//解禁

    boolean review(Integer id);//审核通过

    boolean reject(Integer id);//审核拒绝

    boolean updateGuide(Guide guide);//更新信息


}
