package com.paxsz.i_jdbc_template;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.paxsz.i_jdbc_template.bean.User;
import com.paxsz.i_jdbc_template.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.beans.PropertyVetoException;
import java.util.List;

//演示JDBC模板
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/paxsz/i_jdbc_template/applicationContext.xml")
public class Demo {

    @Resource(name = "userDao")
    private UserDao ud;

    @Test
    public void fun1() throws PropertyVetoException {
        //0 准备连接池
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql:///my_db");
        dataSource.setUser("root");
        dataSource.setPassword("654321");

        //1 创建JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);

        //2 书写sql,并执行
        String sql = "insert into user values(null, 'jack', '000000')";
        jt.update(sql);
    }

    @Test
    public void fun2() {
        User u = new User();
        u.setName("hehe");
        u.setPassword("000000");
        ud.save(u);
    }

    @Test
    public void fun3() {
        User u = new User();
        u.setId(3);
        u.setName("haha");
        ud.update(u);
    }

    @Test
    public void fun4() {
        ud.delete(3);
    }

    @Test
    public void fun5() {
        int count = ud.getTotalCount();
        System.out.println("count - > " + count);
    }

    @Test
    public void fun6() {
        User u = ud.getById(1);
        System.out.println(u);
    }

    @Test
    public void fun7() {
        List<User> list = ud.getAll();
        System.out.println(list);
    }

}
