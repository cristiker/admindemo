package com.cristik.modules.test.service.impl;

import com.cristik.modules.test.dao.DictionaryDao;
import com.cristik.modules.test.entity.test.Dictionary;
import com.cristik.modules.test.service.IDictionaryService;
import com.cristik.modules.test.service.IDictionarysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenghua on 2016/4/1.
 */
@Service
public class DictionarysServiceImpl implements IDictionarysService{
    @Autowired
    DictionaryDao dictionaryMapper;

    @Autowired
    IDictionaryService dictionaryService;

    @Override
    public void loadCaches(){
        List<Dictionary> list =  dictionaryMapper.selectAll();
        for(Dictionary dic : list){
            dictionaryService.getValue(dic);
        }
    }
}
