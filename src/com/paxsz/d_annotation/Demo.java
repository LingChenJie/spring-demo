package com.paxsz.d_annotation;

import com.paxsz.bean2.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    @Test
    public void fun1() {

        //1 创建容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2 向容器"要"user对象
        User u1 = (User) ac.getBean("user_an");
        User u2 = (User) ac.getBean("user_an");

        System.out.println(u1 == u2);
        //3 打印user对象
        System.out.println(u1);

        ac.close();

    }
}
