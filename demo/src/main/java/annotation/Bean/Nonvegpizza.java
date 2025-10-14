package annotation.Bean;

public class Nonvegpizza implements Pizza{

	@Override
	public void getpizza() {
		System.out.println("get nonvegpizza");
	}
		 public void init() {
		        System.out.println(" NonVegPizza is getting ready (init method)");
		    }

		    public void destroy() {
		        System.out.println(" NonVegPizza cleanup done (destroy method)");
		    }
		
	}
	


