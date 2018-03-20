package com.paxsz.c_injection;

import com.paxsz.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class Demo {

    @Test
    public void fun1() {

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/paxsz/c_injection/applicationContext.xml");
        //2 向容器"要"user对象
        User u = (User) ac.getBean("user");
        //3 打印user对象
        System.out.println(u);

    }

    @Test
    public void fun2(){

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/paxsz/c_injection/applicationContext.xml");
        //2 向容器"要"user对象
        User u = (User) ac.getBean("user2");
        //3 打印user对象
        System.out.println(u);

    }

    @Test
    public void fun3(){

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/paxsz/c_injection/applicationContext.xml");
        //2 向容器"要"user对象
        User u = (User) ac.getBean("user3");
        //3 打印user对象
        System.out.println(u);

    }

    @Test
    public void fun4(){

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/paxsz/c_injection/applicationContext.xml");
        //2 向容器"要"user对象
        User u = (User) ac.getBean("user4");
        //3 打印user对象
        System.out.println(u);

    }

    @Test
    public void fun5(){

        //1 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/paxsz/c_injection/applicationContext.xml");
        //2 向容器"要"user对象
        CollectionBean cb = (CollectionBean) ac.getBean("cb");
        //3 打印user对象
        System.out.println(cb);

    }

}
