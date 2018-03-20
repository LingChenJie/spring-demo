package com.paxsz.j_dao_tx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void increaseMoney(Integer id, Double money) {
        String sql = "update account set money = money+? where id = ?";
        getJdbcTemplate().update(sql, money, id);
    }

    @Override
    public void decreaseMoney(Integer id, Double money) {
        String sql = "update account set money = money-? where id = ?";
        getJdbcTemplate().update(sql, money, id);
    }
}
