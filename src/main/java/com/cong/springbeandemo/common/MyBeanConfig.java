package com.cong.springbeandemo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {

    @Bean(name = "beanTest",initMethod = "myInit",destroyMethod = "myDestroy")
    public BeanTest beanTest(){
        BeanTest beanTest = new BeanTest();
        beanTest.setName("张三");
        beanTest.setAge(15);
        System.out.println(beanTest.toString());
        return beanTest;
    }

}
