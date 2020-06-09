package com.youshang520i.demo.proxy.cglibproxy;

import com.youshang520i.demo.proxy.cglibproxy.service.cglibproxy.CglibProxy;
import com.youshang520i.demo.proxy.cglibproxy.service.impl.CglibServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CglibProxyTest {

    @Test
    public void test(){
        Enhancer enhancer = new Enhancer();
        //将目标类设置为父类，cglib动态代理增强的原理就是子类增强父类,cglib不能增强目标类为final的类和方法
        enhancer.setSuperclass(CglibServiceImpl.class);
        //设置当前类的具体子类(允许为null)
        enhancer.setClassLoader(CglibServiceImpl.class.getClassLoader());
        //设置回调接口,这里的MethodInterceptor实现类回调接口，而我们又实现了MethodInterceptor
        enhancer.setCallback(new CglibProxy());
        //create()方法用于创建cglib动态代理对象
        CglibServiceImpl cglibService = (CglibServiceImpl)enhancer.create();
        //实现CGLib代理调用方法
        System.out.println(cglibService.say());
        System.out.println(cglibService.useCase());
        //通过final修饰的方法，CGlib没办法代理
        System.out.println(cglibService.example());

    }
}
