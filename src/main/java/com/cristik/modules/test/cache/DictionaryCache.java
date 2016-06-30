package com.cristik.modules.test.cache;

import com.cristik.modules.test.dao.DictionaryDao;
import com.cristik.modules.test.entity.test.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by zhenghua on 2016/3/31.
 */
public class DictionaryCache {
    @Autowired
    DictionaryDao dictionaryMapper;

    @Cacheable("dickey")
    public String getValue(String table,String column,String key){
        Dictionary dic = new Dictionary(null,table,column,key,null);
        List<Dictionary> list = dictionaryMapper.select(dic);
        return list.get(0).getValueStr();
    }

}
