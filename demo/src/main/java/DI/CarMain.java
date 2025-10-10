package DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarMain {

	public static void main(String[] args) {
		ApplicationContext  context=new ClassPathXmlApplicationContext("car.xml");
		Car car=context.getBean("car",Car.class);
		car.startCar();
		
	}

}
