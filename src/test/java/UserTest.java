import bank.pojo.Account;
import bank.service.Service;
import bank.service.imp.ServiceImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void testUser(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        Service service = (Service)app.getBean("serviceImpM");
        //修改账户jack的同时会插入一个simonDy 100002的账户
        //由于事务机制修改账户会成功100000,插入不会成功
        service.modify(new Account(null,"jack",100000d));

    }
}
