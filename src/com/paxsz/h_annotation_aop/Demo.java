package com.paxsz.h_annotation_aop;

import com.paxsz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/paxsz/h_annotation_aop/applicationContext.xml")
public class Demo {

    @Resource(name="userService")
    private UserService us;

    @Test
    public void fun1() {
        us.save();
    }
}
