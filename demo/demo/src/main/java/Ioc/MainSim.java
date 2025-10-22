package Ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSim {
    public static void main(String[] args) {
        ApplicationContext context = 
                new ClassPathXmlApplicationContext("bean.xml"); // load XML

        Mobilesim mobile = context.getBean( Mobilesim.class); // bean id from XML
        mobile.makeCall();
        mobile.network();
    }
}
