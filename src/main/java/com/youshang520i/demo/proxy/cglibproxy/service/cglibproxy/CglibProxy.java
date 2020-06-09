package com.youshang520i.demo.proxy.cglibproxy.service.cglibproxy;

import cn.hutool.core.date.DateUtil;
import com.youshang520i.demo.proxy.cglibproxy.service.CglibService;
import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 实现CGLib核心接口 MethodInterceptor
 */
@Log4j2
public class CglibProxy implements MethodInterceptor {

    private Long startTime;

    public CglibProxy(){
        startTime = System.currentTimeMillis();
    }

    /**
     * 回调接口的方法
     * 回调接口的方法执行的条件是：代理对象执行目标方法时会调用回调接口的方法
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        log.info(String.format("方法名: %s",method.getName()));
        log.info(String.format("开始执行日期: %s ", DateUtil.date(startTime)));

        Object o = proxy.invokeSuper(obj, args);

        long endTime = System.currentTimeMillis();
        log.info(String.format("方法总共执行时间: %s 毫秒",endTime - startTime));
        return o;
    }
}
