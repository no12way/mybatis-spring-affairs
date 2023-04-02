import bank.service.Service;
import bank.service.imp.ServiceImp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTran {
    @Test
    public void testS(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
        Service service = (ServiceImp)app.getBean("serviceImp");
        service.select("jack");
    }
}
