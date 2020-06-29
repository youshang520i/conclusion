package com.youshang520i.demo.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解
 * @author youshang
 * @Target 定义注解的使用位置，用来说明该注解可以被声明在那些元素之前。
 *         ElementType.TYPE：说明该注解只能被声明在一个类前。
 *         ElementType.FIELD：说明该注解只能被声明在一个类的字段前。
 *         ElementType.METHOD：说明该注解只能被声明在一个类的方法前。
 *@Retention 定义了该Annotation的“生命周期”限制
 *         SOURCE:在源文件中有效（即源文件保留）
 *         CLASS:在class文件中有效（即class保留）
 *         RUNTIME:在运行时有效（即运行时保留）
 *@Documented 用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheRedis {

    String key();

    int expireTime() default 3000;

}
