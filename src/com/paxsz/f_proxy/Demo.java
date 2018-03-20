package com.paxsz.f_proxy;

import com.paxsz.service.UserService;
import com.paxsz.service.UserServiceImpl;
import org.junit.Test;

public class Demo {

    @Test
    // 动态代理
    public void fun1() {
        UserService us = new UserServiceImpl();

        UserServiceProxyFactory factory = new UserServiceProxyFactory(us);

        UserService serviceProxy = factory.getUserServiceProxy();

        serviceProxy.save();

        //代理对象与被代理对象实现了相同的接口
        //代理对象 与 被代理对象没有继承关系
        System.out.println(serviceProxy instanceof UserServiceImpl);//false
    }

    @Test
    // cgLib
    public void fun2() {

        UserServiceProxyFactory2 factory2 = new UserServiceProxyFactory2();

        UserService proxy = factory2.getUserServiceProxy();

        proxy.save();

        //判断代理对象是否属于被代理对象类型
        //代理对象继承了被代理对象=>true
        System.out.println(proxy instanceof UserServiceImpl);//true
    }
}
