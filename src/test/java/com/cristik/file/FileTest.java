package com.cristik.file;

import com.cristik.common.utils.PropertiesUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by zhenghua on 2016/3/24.
 */
public class FileTest {

    @Test
    public void testProperties() throws IOException {
        String value = PropertiesUtil.getProperty("ShiroTest.class","file.path");
        System.out.println(value);
    }
}
