package com.sun.furn.service;


import com.sun.furn.bean.Furn;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author 孙显圣
 * @version 1.0
 */
public class FurnServiceTest {
    //获取ioc容器
    private ApplicationContext ioc;
    //获取针对FurnService接口的代理对象
    private FurnService furnService;

    //初始化方法，在所有测试方法之前执行

    @Before
    public void init() {
        //读取sping配置文件，获取ioc容器，此时所有的单例bean已经被反射创建bean对象，依赖注入，初始化完毕
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取针对FurnService接口的代理对象
        furnService = ioc.getBean(FurnService.class);
    }

    @Test
    public void save() {
        Furn furn = new Furn(null, "桌子", "熊猫家居", new BigDecimal(12.3), 21, 11, "assets/images/product-image/14.jpg");
        furnService.save(furn);
    }


}