package annotation.Primary;

import org.springframework.stereotype.Component;

@Component
public class CreditcardPayment {
	public void pay() {
		System.out.println("Payment done using Credit Card ");
	}

}
