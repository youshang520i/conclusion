package com.youshang520i.demo.proxy.jdkproxy.proxy;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Proxy;

/**
 * JDK1.6+ 底层提供的动态代理
 */
@Log4j2
public class JdkProxy {

    private Object object;

    public JdkProxy(Object object){
        this.object = object;
    }

    /**
     * 封装代理方法,取代实现InvocationHandler
     * @return
     */
    public Object getProxyInstance() {
        long startTime = System.currentTimeMillis();
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), (proxy, method, args) -> {
            DateTime startDate = DateUtil.date(startTime);
            log.info(String.format("开始操作你的需求: %s ",startDate));
            //进行代理
            Object invoke = method.invoke(object, args);

            long endTime = System.currentTimeMillis();
            log.info(String.format("操作此需求总共耗时: %s 毫秒",(endTime- startTime)));

            return invoke;
        });
    }

//    (proxy, method ,args) -> method.invoke(proxy,args)
//    =
//    new InvocationHandler() {
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//            return method.invoke(object,args);
//        }
}
