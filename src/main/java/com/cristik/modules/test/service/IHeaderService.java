package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.svo.Header;

/**
 * Created by zhenghua on 2016/5/18.
 */
public interface IHeaderService {

    Header getHeader();

    boolean update(Header header);

    boolean insert(Header header);

}
