package com.youshang520i.demo.springlifecycle.postPercessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostPercessor implements BeanPostProcessor {

    public MyBeanPostPercessor(){
        System.out.println("第五步：实例MyBeanPostPercessor构造方法");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
