package com.cong.springbeandemo.common;


import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * InstantiationAwareBeanPostProcessorAdapter已经标记为过时
 * Deprecated
 * as of 5.3 in favor of implementing InstantiationAwareBeanPostProcessor or SmartInstantiationAwareBeanPostProcessor directly.
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("beanTest"))
            System.out.println("InstantiationAwareBeanPostProcessor===postProcessBeforeInstantiation");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanTest"))
            System.out.println("InstantiationAwareBeanPostProcessor===postProcessAfterInstantiation");
        return false;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (beanName.equals("beanTest"))
            System.out.println("InstantiationAwareBeanPostProcessor===postProcessProperties");
        return pvs;
    }
}
