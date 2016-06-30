package com.cristik.modules.test.service;

import com.cristik.modules.test.entity.test.Dictionary;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by zhenghua on 2016/4/20.
 */
public interface IDictionaryService {

    @Cacheable(value="statuscache",key="#dic.tableName+#dic.columnName+#dic.keyStr")
    String getValue(Dictionary dic);
}
