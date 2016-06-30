package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.DictionaryDao;
import com.cristik.modules.test.entity.test.Dictionary;
import com.cristik.modules.test.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by zhenghua on 2016/4/1.
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService{
    @Autowired
    DictionaryDao dictionaryMapper;

    @Override
    @Cacheable(value="statuscache",key="#dic.tableName+#dic.columnName+#dic.keyStr")
    public String getValue(Dictionary dic){
        System.out.println("loading data from database...");
        return dic.getValueStr();
    }
}
