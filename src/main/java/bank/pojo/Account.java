package bank.pojo;

import org.springframework.stereotype.Repository;

@Repository
public class Account {
    private Long  id;
    private String cusName;
    private Double balance;
    public Account(){}

    public Account(Long id, String cusName, Double balance) {
        this.id = id;
        this.cusName = cusName;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cusName='" + cusName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
