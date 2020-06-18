package com.youshang520i.demo.annotation;

import com.youshang520i.demo.annotation.service.YayiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomAnnotationTest {

    @Autowired
    private YayiService yayiService;

    @Test
    public void yayiTest(){
        System.out.println(yayiService.say(10));
    }
}
