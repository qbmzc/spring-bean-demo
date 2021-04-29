package com.cong.springbeandemo.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanProcessor implements BeanPostProcessor {

    public MyBeanProcessor() {
        super();
        System.out.println("MyBeanProcessor构造函数");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName);
        if (beanName.equals("beanTest"))
            System.out.println(beanName+"=============postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName);
        if (beanName.equals("beanTest"))
            System.out.println(beanName+"==========postProcessAfterInitialization");
        return bean;
    }
}
