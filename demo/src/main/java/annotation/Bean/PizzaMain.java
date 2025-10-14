package annotation.Bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PizzaMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(PizzaConfig.class);
		Vegpizza veg=context.getBean(Vegpizza.class);
		veg.getpizza();
		 Nonvegpizza nonveg = context.getBean(Nonvegpizza.class);
	        nonveg.getpizza();
	        context.close();
				
	}

}
