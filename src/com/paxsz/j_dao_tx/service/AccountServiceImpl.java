package com.paxsz.j_dao_tx.service;

import com.paxsz.j_dao_tx.dao.AccountDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class AccountServiceImpl implements AccountService {

    private AccountDao ad;
    private TransactionTemplate tt;

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(Integer from, Integer to, Double money) {
        //减钱
        ad.decreaseMoney(from, money);
        int i = 1 / 0;
        //加钱
        ad.increaseMoney(to, money);
    }

//    @Override
//    public void transfer(Integer from, Integer to, Double money) {
//        tt.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
//                //减钱
//                ad.decreaseMoney(from, money);
//                int i = 1 / 0;
//                //加钱
//                ad.increaseMoney(to, money);
//            }
//        });
//    }

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    public void setTt(TransactionTemplate tt) {
        this.tt = tt;
    }

}
