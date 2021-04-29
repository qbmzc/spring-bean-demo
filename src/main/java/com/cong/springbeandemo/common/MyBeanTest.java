package com.cong.springbeandemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class MyBeanTest {

    @Autowired
    private BeanTest bean;

    @GetMapping
    public String test(){
        System.out.println(bean);
        return "";
    }
}
