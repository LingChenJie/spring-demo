package com.paxsz.f_proxy;

import com.paxsz.service.UserService;
import com.paxsz.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//观光代码=>动态代理
public class UserServiceProxyFactory implements InvocationHandler {

    private UserService us;

    public UserServiceProxyFactory(UserService us) {
        this.us = us;
    }

    //生成动态代理
    public UserService getUserServiceProxy() {
        UserService usProxy = (UserService) Proxy.newProxyInstance(UserServiceProxyFactory.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), this);
        return usProxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开事务!");
        Object invoke = method.invoke(us, args);
        System.out.println("提交事务!");
        return invoke;
    }
}
