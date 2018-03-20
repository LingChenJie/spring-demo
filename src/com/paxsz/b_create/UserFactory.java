package com.paxsz.b_create;

import com.paxsz.bean.User;

public class UserFactory {

    public static User createUser() {

        System.out.println("静态工厂创建User");

        return new User();

    }

    public User createUser2() {

        System.out.println("实例工厂创建User");

        return new User();

    }

}
