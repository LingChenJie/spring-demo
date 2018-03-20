package com.paxsz.i_jdbc_template.dao;

import com.paxsz.i_jdbc_template.bean.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//使用JDBC模板实现增删改查
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Override
    public void save(User u) {
        String sql = "insert into user values(null,?,?)";
        getJdbcTemplate().update(sql, u.getName(), u.getPassword());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from user where id = ?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public void update(User u) {
        String sql = "update user set name = ? where id = ?";
        getJdbcTemplate().update(sql, u.getName(), u.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from user where id = ?";
        User user = getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                u.setPassword(resultSet.getString("password"));
                return u;
            }
        }, id);
        return user;
    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from user";
        Integer count = getJdbcTemplate().queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public List<User> getAll() {
        String sql = "select * from user";
        List<User> list = getJdbcTemplate().query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setName(resultSet.getString("name"));
                return u;
            }
        });
        return list;
    }
}
