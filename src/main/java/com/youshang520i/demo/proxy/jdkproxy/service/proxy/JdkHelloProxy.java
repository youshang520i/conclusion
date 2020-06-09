package com.youshang520i.demo.proxy.jdkproxy.service.proxy;

import com.youshang520i.demo.proxy.jdkproxy.service.JdkHello;
import com.youshang520i.demo.proxy.jdkproxy.service.impl.JdkHelloImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JdkHelloProxy implements JdkHello {

    private JdkHello jdkHello = new JdkHelloImpl();

    @Override
    public String hello() {
        log.info("通过动态代理执行hello");
        return jdkHello.hello();
    }

    @Override
    public final String world() {
        log.info("通过动态代理执行world");
        return jdkHello.world();
    }
}
