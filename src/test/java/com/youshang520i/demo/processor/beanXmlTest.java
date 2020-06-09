package com.youshang520i.demo.processor;


import com.youshang520i.demo.springlifecycle.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanXmlTest {

    @Test
    public void loadXmlTest(){
        System.out.println("第一步: 加载xml文件");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);

    }
}
