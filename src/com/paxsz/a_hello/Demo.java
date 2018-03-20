package com.paxsz.a_hello;

import com.paxsz.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

/**
 * spring入门小程序
 */
public class Demo {

    @Test
    public void fun1() {
        // 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 从容器中获取user对象
        User u = (User) ac.getBean("user");

        System.out.println(u);

    }
}
