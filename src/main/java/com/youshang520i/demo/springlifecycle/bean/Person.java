package com.youshang520i.demo.springlifecycle.bean;

import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@ToString
public class Person implements BeanFactoryAware, BeanNameAware,InitializingBean,BeanClassLoaderAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware

{

    public Person(){
        System.out.println("第七步: 实例化Person构造方法");
    }

    private String name;
    private Integer age;


    /**
     * 将当前的Bean的BeanFactory的实例传入
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第十步：将当前的Bean的BeanFactory的实例传入 执行(setBeanFactory)方法");
    }

    /**
     * 将Bean的ID传递给setBeanName()
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        System.out.println("第九步：将Bean的ID传递给setBeanName执行(setBeanName)方法");
    }


//    @Bean(initMethod = "initAnnotation")
    public void initAnnotation(){
        System.out.println("注解使用initMethod");
    }
    /**
     * bean初始化方法
     */
    public void initMethod(){
        System.out.println("第十二步: bean初始化的时候执行(initMethod)方法");
    }

    /**
     * bean销毁的时候执行的方法
     */
    public void destroyMethod(){
        System.out.println("第N步： bean销毁的时候执行(destroyMethod)方法");
    }



    public void setName(String name) {
//        System.out.println(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
//        System.out.println(age);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现的afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("在执行BeanNameAware之后执行。。。"+classLoader.getClass().getName());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("在执行setBeanFactory之后执行。。。。");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        try {
            applicationEventPublisher.publishEvent(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("在执行setResourceLoader之后执行。。。。"+applicationEventPublisher.toString());
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("在执行setApplicationEventPublisher之后执行。。。。");
    }


    @PostConstruct
    public void post(){
        System.out.println("在InitMethod执行之前：post......postConstruct....");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("在DestroyMethod方法执行之前执行 : destroy......preDestroy");
    }
}
