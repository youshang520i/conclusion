package com.youshang520i.demo.annotation.service;


import com.youshang520i.demo.annotation.CacheRedis;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Log4j2
@Aspect
@Component
public class CacheService {
    /**
     * 切入点
     */
    @Pointcut(value = "@annotation(com.youshang520i.demo.annotation.CacheRedis)")
    public void pointCut(){}

    @Before(value = "pointCut() && @annotation(cacheRedis)")
    public void before(CacheRedis cacheRedis) {
        log.info("the result of this method will be cached.(此方法的结果将被缓存)");
        String str = null;
        str.toString();
    }



    /**
     * 后置通知
     * @param cacheRedis
     * @param result
     */
    @AfterReturning(value = "pointCut() && @annotation(cacheRedis)",returning = "result")
    public void after(CacheRedis cacheRedis,Object result) {
        String key = cacheRedis.key();
        int expireTime = cacheRedis.expireTime();
        //do something...
        log.info("-----redis-----[key = " + key + "]"+"[expireTime = " + expireTime + "]");
        log.info("the result of this method is " + result + ",and has been cached.(该方法的结果是 "+ result +"，并已被缓存。)");
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @param cacheRedis
     * @return
     */
    @Around("pointCut() && @annotation(cacheRedis)")
    public Object setCache(ProceedingJoinPoint joinPoint, CacheRedis cacheRedis) {
        Object result = 1;
        log.info(String.format("当前调用的类名: %s",joinPoint.getSignature().getDeclaringType().getName()));
        Method method = getMethod(joinPoint);//自定义注解类
        log.info(String.format("自定义注解类: %s ", method));
//        CacheRedis cacheRedis = method.getAnnotation(CacheRedis.class);//获取key值
        String key = cacheRedis.key();
        int expireTime = cacheRedis.expireTime();
        //获取方法的返回类型,让缓存可以返回正确的类型
        Class returnType =((MethodSignature)joinPoint.getSignature()).getReturnType();

        log.info("[key = " + key + "]"+"[expireTime = " + expireTime + "] , returnType : " + returnType);

        return result;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint) {
        //获取参数的类型
        Method method = null;
        try {
            Signature signature = joinPoint.getSignature();
            MethodSignature msig = null;
            if (!(signature instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能用于方法");
            }
            msig = (MethodSignature) signature;
            method = joinPoint.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes());
        } catch (NoSuchMethodException e) {
            log.error("annotation no sucheMehtod", e);
        } catch (SecurityException e) {
            log.error("annotation SecurityException", e);
        }
        return method;
    }

    @AfterThrowing(value = "pointCut()" ,throwing = "throwable")
    public void throwingMethod(Throwable throwable){
        log.info(String.format("throwingMethod: %s",throwable.getLocalizedMessage()));
    }
}
