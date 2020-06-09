package com.youshang520i.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("test.xml");
        Object person2 = classPathXmlApplicationContext.getBean("person2");
        System.out.println(person2);
    }

}
