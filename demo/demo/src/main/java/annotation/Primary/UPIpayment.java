package annotation.Primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UPIpayment extends CreditcardPayment {
	@Override
	public void pay() {
		System.out.println("Payment done using UPI ");
	}

}
