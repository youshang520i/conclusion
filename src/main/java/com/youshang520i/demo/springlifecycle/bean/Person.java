package com.youshang520i.demo.springlifecycle.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

public class Person implements BeanFactoryAware, BeanNameAware {

    /**
     * 将当前的Bean的BeanFactory的实例传入
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    /**
     * 将Bean的ID传递给setBeanName()
     * @param name
     */
    @Override
    public void setBeanName(String name) {

    }
}
