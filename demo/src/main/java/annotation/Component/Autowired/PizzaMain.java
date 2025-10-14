package annotation.Component.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaMain {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context =
	        new AnnotationConfigApplicationContext("AnnotationConfig"); // scan package
	PizzaController pizza = context.getBean(PizzaController.class);
	pizza.showpizza();
	
}
}