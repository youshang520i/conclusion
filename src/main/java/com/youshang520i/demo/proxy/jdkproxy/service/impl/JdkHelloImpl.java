package com.youshang520i.demo.proxy.jdkproxy.service.impl;

import com.youshang520i.demo.proxy.jdkproxy.service.JdkHello;
import org.springframework.stereotype.Service;

/**
 * @author youshang
 */
public class JdkHelloImpl implements JdkHello {


    @Override
    public String hello() {
        return "hello";
    }

    @Override
    public String world() {
        return "world";
    }
}
