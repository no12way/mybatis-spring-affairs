package bank.service;

import bank.pojo.Account;

public interface Service {
    /**
     * 开户
     * @param account
     * @return
     */
    void save(Account account);

    /**
     * 注销账户
     * @param id
     */
    void delete(Long id);

    /**
     * 修改账户
     * @param account
     */
    void modify(Account account);

    /**
     * 查询账户
     * @param name
     */
    void select(String name);

    /**
     * 查询所有账户
     */
    void selectAll();

    void transfer(String fromName,String toName,Double balance);
}
