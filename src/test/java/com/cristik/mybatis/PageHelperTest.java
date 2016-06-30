package com.cristik.mybatis;

import com.cristik.modules.test.dao.UserDao;
import com.cristik.modules.test.entity.svo.User;
import com.cristik.common.base.PageInfo;
import com.cristik.common.utils.PageInfoUtil;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhenghua on 2016/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-context.xml" })
@Transactional
public class PageHelperTest {
    @Autowired
    UserDao userMapper;

    @Test
    public void testPageHelper(){
        PageInfo page = new PageInfo();
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<User> list = userMapper.selectAll();
        page = PageInfoUtil.parseList(list);
        System.out.println(page.toJSONString());

    }


}
