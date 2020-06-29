package com.youshang520i.demo.processor;


import com.youshang520i.demo.springlifecycle.bean.BeanLifecycle;
import com.youshang520i.demo.springlifecycle.bean.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class beanXmlTest {

    @Test
    public void loadXmlTest(){
        System.out.println("第一步: 加载xml文件");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println(beanFactory);
        if (beanFactory instanceof BeanDefinitionRegistry) {
            BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(BeanLifecycle.class)
                    .addPropertyValue("name", "张三")
                    .getBeanDefinition();
            ((BeanDefinitionRegistry) beanFactory).registerBeanDefinition("beanLifecycle", beanDefinition);
        }
        BeanLifecycle beanLifecycle = (BeanLifecycle)applicationContext.getBean("beanLifecycle");
        System.out.println(beanLifecycle);
        applicationContext.close();

//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
//        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");
////        AutowiredAnnotationBeanPostProcessor 启用autowired的关键
//        Object person1 = defaultListableBeanFactory.getBean("person");
//        System.out.println(person1);
    }

    @Test
    public void BeanFactoryTest(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeanLifecycle.xml");
//        Object beanLifecycle = applicationContext.getBean("beanLifecycle");
//        System.out.println(beanLifecycle);

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("BeanLifecycle.xml");
        Object beanLifecycle = defaultListableBeanFactory.getBean("beanLifecycle");

        System.out.println(beanLifecycle);


    }


}
