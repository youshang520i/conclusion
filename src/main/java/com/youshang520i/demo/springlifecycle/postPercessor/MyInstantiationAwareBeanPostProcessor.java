package com.youshang520i.demo.springlifecycle.postPercessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.lang.Nullable;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public MyInstantiationAwareBeanPostProcessor(){
        System.out.println("第四步： 实例MyInstantiationAwareBeanPostProcessor的构造方法");
    }

    /**
     * bean实例化之前执行
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("第六步： Bean实例化之前执行(postProcessBeforeInstantiation)方法");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("第六步：Bean实例化之后执行(postProcessAfterInstantiation)方法");
        return true;
    }

//    @Override
//    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//        System.out.println("迷：postProcessProperties");
//        return null;
//    }

    /**
     * 执行bean的set操作的时候会先执行此操作
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("第八步：执行bean的set操作的时候会先执行(postProcessPropertyValues)操作");
        return null;
    }

}
