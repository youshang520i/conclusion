package com.youshang520i.demo.processor;


import com.youshang520i.demo.springlifecycle.bean.Person;
import com.youshang520i.demo.springlifecycle.bean.Person2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

public class beanXmlTest {

    @Test
    public void test(){
        System.out.println("第一步: 加载xml文件");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);

        Person2 bean = applicationContext.getBean(Person2.class);
        System.out.println(bean);

        Person2 bean2 = (Person2)applicationContext.getBean("person2");
        System.out.println(bean2);
    }
}
