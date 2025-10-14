package annotation.Component.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzaController {
//	field injection
	@Autowired
	private VegPizza vegpizza;

//	@Autowired
////	constructor injection
//	public PizzaController(VegPizza vegpizza) {
//		this.vegpizza = vegpizza;
//	}
//	setter injection
//	@Autowired
//	public void setpizza(VegPizza vegpizza) {
//		this.vegpizza = vegpizza;
//	}
	public void showpizza() { 
		vegpizza.pizzatype();
	}
	
	

}
