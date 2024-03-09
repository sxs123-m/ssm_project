package com.sun.furn.test;

import com.sun.furn.bean.Furn;
import com.sun.furn.dao.FurnMapper;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author 孙显圣
 * @version 1.0
 */
public class FurnMapperTest {
    @Test
    public void insertSelective() {
        //获取容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用接口类型来获取单例bean，可以使用接口类型的原因是，接口类已经被Spring容器扫描
        FurnMapper bean = ioc.getBean(FurnMapper.class); //这个返回的也是一个代理对象，使用代理对象来执行实现类的方法
        Furn furn = new Furn(null, "桌子", "熊猫家居", new BigDecimal(12.3), 21, 11, "assets/images/product-image/14.jpg");
        int i = bean.insertSelective(furn);
        if (i == 1) {
            System.out.println("插入成功！");
        }
    }

    @Test
    public void deleteByPrimaryKey() {
        //获取容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用接口类型来获取单例bean，可以使用接口类型的原因是，接口类已经被Spring容器扫描
        FurnMapper bean = ioc.getBean(FurnMapper.class); //这个返回的也是一个代理对象，使用代理对象来执行实现类的方法
        int i = bean.deleteByPrimaryKey(2);
        if (i == 1) {
            System.out.println("删除成功");
        }
    }

    @Test
    public void updateByPrimaryKeySelective() {
        //获取容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用接口类型来获取单例bean，可以使用接口类型的原因是，接口类已经被Spring容器扫描
        FurnMapper bean = ioc.getBean(FurnMapper.class); //这个返回的也是一个代理对象，使用代理对象来执行实现类的方法
        Furn furn = new Furn();
        furn.setId(1);
        furn.setName("桌子");
        int i = bean.updateByPrimaryKeySelective(furn);
        if (i == 1) {
            System.out.println("修改成功");
        }
    }

    @Test
    public void selectByPrimaryKey() {
        //获取容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //使用接口类型来获取单例bean，可以使用接口类型的原因是，接口类已经被Spring容器扫描
        FurnMapper bean = ioc.getBean(FurnMapper.class); //这个返回的也是一个代理对象，使用代理对象来执行实现类的方法
        Furn furn = bean.selectByPrimaryKey(1);
        System.out.println(furn);
    }




}









