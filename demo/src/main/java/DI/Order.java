package DI;

public class Order {
	private int orderID;
	private String ordername;
	private Customer customer;
	public Order(int orderID, String ordername, Customer customer) {
		super();
		this.orderID = orderID;
		this.ordername = ordername;
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", ordername=" + ordername + ", customer=" + customer + "]";
	}
	
	

}
