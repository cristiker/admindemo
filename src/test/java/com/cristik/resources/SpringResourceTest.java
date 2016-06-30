package com.cristik.resources;

import org.junit.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class SpringResourceTest {
    @Test
    public void testClassPathResource(){
        ClassPathResource resource = new ClassPathResource("test/file2.properties");
        System.out.println(resource.exists());

        FileSystemResource fileSystemResource = new FileSystemResource("test/file2.properties");
        System.out.println(fileSystemResource.exists());



    }

}
