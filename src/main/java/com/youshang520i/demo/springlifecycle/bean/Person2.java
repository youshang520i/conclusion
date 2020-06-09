package com.youshang520i.demo.springlifecycle.bean;

import lombok.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person2{


    private String name;
    private Integer age;



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
