package com.youshang520i.demo.springlifecycle.postPercessor;

import com.sun.jndi.rmi.registry.RegistryContextFactory;
import com.youshang520i.demo.springlifecycle.bean.BeanLifecycle;
import com.youshang520i.demo.springlifecycle.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.support.ResourceEditorRegistrar;

public class MyBeanFactpryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactpryPostProcessor(){
        System.out.println("第二步：实例化MyBeanFactpryPostPersessor构造方法！！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("第三步：执行postProcessBeanFactory");


        BeanDefinition person = configurableListableBeanFactory.getBeanDefinition("person");
        person.getPropertyValues().addPropertyValue("name","zs");











    }
}
