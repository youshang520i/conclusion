package com.youshang520i.demo.proxy.cglibproxy.service.impl;

import com.youshang520i.demo.proxy.cglibproxy.service.CglibService;

public class CglibServiceImpl implements CglibService {
    @Override
    public String say() {
        return "say";
    }

    @Override
    public String useCase() {
        return "useCase";
    }

    /**
     * final修饰的方法,CGLib不能代理
     * @return
     */
    public final String example(){
        return "劳资的东西你别碰。。。";
    }
}
