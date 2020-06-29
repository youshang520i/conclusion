package com.youshang520i.demo.springlifecycle.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.net.URL;

/**
 * 专门用于描述bean的生命周期
 * @author youshang
 */
@ToString
public class BeanLifecycle extends RootBeanDefinition implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware, ApplicationEventPublisherAware,
        MessageSourceAware, ServletContextAware, InitializingBean,DisposableBean,ApplicationContextAware {

    private String name;
    private String annotation;
    private RelyOn relyOn;
    private String resourceUrl;

    public void setName(String name) {
        this.name = name;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getName() {
        return name;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setRelyOn(RelyOn relyOn) {
        this.relyOn = relyOn;
    }

    public RelyOn getRelyOn() {
        return relyOn;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanFactory第一步加载，beanName: "+ name);
    }

    @SneakyThrows
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

        URL resourceUrl = classLoader.getResource("BeanLifecycle.xml");
//        System.out.println(resourceUrl.getPath());
        this.resourceUrl = resourceUrl.getPath();

        System.out.println("执行完setBeanName之后，执行setBeanClassLoader.getResource().getPath() : " + resourceUrl);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        beanFactory.isSingleton("bean")
        Class<?> beanLifecycle = beanFactory.getType("&beanLifecycle");
        System.out.println(beanFactory);
        System.out.println("执行完setBeanClassLoader之后执行 setBeanFactory.getBean( beanLifecycle ) : "+ beanFactory.getBean("beanLifecycle"));
    }

    @SneakyThrows
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        Resource resource = resourceLoader.getResource("BeanLifecycle.xml");
        System.out.println(resource.getURL());
        System.out.println("执行完setBeanFactory之后执行setResourceLoader.getResource().getURL() : "+resource.getURL());
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        try {
            applicationEventPublisher.publishEvent(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ClassPathXmlApplicationContext applicationEventPublisher1 = (ClassPathXmlApplicationContext) applicationEventPublisher;
        System.out.println(applicationEventPublisher);
        System.out.println("执行完setResourceLoader之后执行setApplicationEventPublisher. : " + "应用活动发布者。。需要康康。。");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("执行完setApplicationEventPublisher之后执行setMessageSource. : " + "国际化配置。。。。"+ messageSource);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(BeanLifecycle.class);
        for (String s : beanNamesForType) {
            System.out.println(s
            );
        }
        String[] defaultProfiles = applicationContext.getEnvironment().getDefaultProfiles();
        for (String defaultProfile : defaultProfiles) {
            System.out.println(defaultProfile);
        }
        for (String activeProfile : applicationContext.getEnvironment().getActiveProfiles()) {
            System.out.println(activeProfile);
        }
        System.out.println("执行完setMessageSource之后执行setApplicationContext.getApplicationName() : " +""+applicationContext);
    }


    /**
     * ClassPathXmlApplicationContext加载配置文件的时候没有加载到
     * @param servletContext
     */
    @Override
    public void setServletContext(ServletContext servletContext) {
        System.out.println("执行完setApplicationContext之后执行setServletContext.getContextPath : " + servletContext.getContextPath());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行完setServletContext之后执行afterPropertiesSet ： initMethod");
    }
    /**
     * ClassPathXmlApplicationContext加载配置文件的时候没有加载到
     */
    @Override
    public String getInitMethodName() {
        System.out.println("getInitMethodName: "+super.getInitMethodName());
        return super.getInitMethodName();
    }
    /**
     * ClassPathXmlApplicationContext加载配置文件的时候没有加载到
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("销毁");
    }
    /**
     * ClassPathXmlApplicationContext加载配置文件的时候没有加载到
     */
    @Override
    public String getDestroyMethodName() {
        System.out.println("getDestroyMethodName : "+super.getDestroyMethodName());
        return super.getDestroyMethodName();
    }


}
