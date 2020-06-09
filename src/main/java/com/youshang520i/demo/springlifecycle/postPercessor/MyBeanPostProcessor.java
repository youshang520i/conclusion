package com.youshang520i.demo.springlifecycle.postPercessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor(){
        System.out.println("第五步：实例MyBeanPostPercessor构造方法");
    }

    /**
     * 执行init-method方法之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第十一步： 执行init-method方法之前执行(postProcessBeforeInitialization)");
        return bean;
    }

    /**
     * 执行init-method方法之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第十三步： 执行init-method方法之后执行(postProcessAfterInitialization)");
        return bean;
    }
}
