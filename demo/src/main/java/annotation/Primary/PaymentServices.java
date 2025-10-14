package annotation.Primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentServices extends UPIpayment {
	@Autowired
	private UPIpayment UPI;

	public void payment() {

		UPI.pay();
	}

}
