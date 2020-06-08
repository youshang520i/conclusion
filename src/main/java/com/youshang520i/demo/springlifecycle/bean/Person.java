package com.youshang520i.demo.springlifecycle.bean;

import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

@ToString
public class Person implements BeanFactoryAware, BeanNameAware{

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
        System.out.println(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        System.out.println(age);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

}
