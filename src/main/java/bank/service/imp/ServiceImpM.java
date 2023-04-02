package bank.service.imp;

import bank.dao.AccountMapper;
import bank.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
    @Service
    public class ServiceImpM implements bank.service.Service {
        @Autowired
        @Qualifier("accountMapper")
        private AccountMapper accountMapper;

        @Autowired
        @Qualifier("serviceImp")
        private bank.service.Service service;

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
        @Transactional(propagation = Propagation.REQUIRED)
        public void modify(Account account) {
            int i = accountMapper.updateByName(account);
            if (i == 1){
                System.out.println("修改账户成功");
            }
            try{
            service.save(new Account(null,"dimonSy",100002d));}
            catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("开户成功");
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

