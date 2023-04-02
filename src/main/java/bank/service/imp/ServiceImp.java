package bank.service.imp;

import bank.dao.AccountMapper;
import bank.pojo.Account;
import bank.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.swing.*;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp implements Service {
    @Autowired
    @Qualifier("accountMapper")
    private AccountMapper accountMapper;
    @Override
    public void save(Account account) {
        accountMapper.insert(account);
    }

    @Override
    public void delete(Long id) {
        int i = accountMapper.deleteById(id);
        if (i == 1){
            System.out.println("账户已注销");
        }
    }

    @Override
    public void modify(Account account) {
        int i = accountMapper.updateByName(account);
        if (i == 1){
            System.out.println("修改账户成功");
        }
    }

    @Override
    public void select(String name) {
        Account account = accountMapper.selectByName(name);
        System.out.println(account);
    }

    @Override
    public void selectAll() {
        List<Account> accounts = accountMapper.selectAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Override
    public void transfer(String fromName, String toName, Double balance) {
        Account fromAccount = accountMapper.selectByName(fromName);
        Account toAccount = accountMapper.selectByName(toName);
        //余额足够,进行转账
        if (fromAccount.getBalance() >= balance){
            fromAccount.setBalance(fromAccount.getBalance() - balance);
        }
        int i = accountMapper.updateByName(fromAccount);
        toAccount.setBalance(toAccount.getBalance()+balance);
        int i1 = accountMapper.updateByName(toAccount);
        if(i+i1 == 2){
            System.out.println("转账成功");
        }
        else {System.out.println("转账失败");}
    }
}
