package DI;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCust {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("Cust.xml");
		Order order=(Order) context.getBean("ord");
		System.out.println(order.toString());
		}

}
