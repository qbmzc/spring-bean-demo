package com.cong.springbeandemo.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class BeanTest implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private Integer age;

    public BeanTest() {
        System.out.println("无参构造实例化");
    }

    public BeanTest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName......");
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge......");
        this.age = age;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAware:setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println( "BeanNameAware:setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean:destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println( "InitializingBean:afterPropertiesSet");
    }

    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestroy() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }

    @Override
    public String toString() {
        return "BeanTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
