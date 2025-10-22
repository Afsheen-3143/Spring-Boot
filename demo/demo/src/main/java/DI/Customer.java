package DI;

public class Customer {
	private int age;
	private String name;
	private String contact;
	public Customer(int age, String name, String contact) {
		super();
		this.age = age;
		this.name = name;
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Customer [age=" + age + ", name=" + name + ", contact=" + contact + "]";
	}
	
	

}
