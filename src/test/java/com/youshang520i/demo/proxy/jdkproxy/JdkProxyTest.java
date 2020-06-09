package com.youshang520i.demo.proxy.jdkproxy;

import com.youshang520i.demo.proxy.jdkproxy.proxy.JdkProxy;
import com.youshang520i.demo.proxy.jdkproxy.service.JdkHello;
import com.youshang520i.demo.proxy.jdkproxy.service.proxy.JdkHelloProxy;
import org.junit.Test;

/**
 * 测试jdk动态代理
 */
public class JdkProxyTest {

    @Test
    public void test(){
        //通过代理类实现调用JdkHelloImpl实现类
        JdkHello jdkHello = new JdkHelloProxy();
        //执行代理操作
        JdkHello jdkHelloProxy = (JdkHello)new JdkProxy(jdkHello).getProxyInstance();
        System.out.println(jdkHelloProxy.hello());

        //经过final修饰的方法
        System.out.println(jdkHelloProxy.world());
    }
}
