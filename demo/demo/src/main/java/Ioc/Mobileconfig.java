package Ioc;

import org.springframework.context.annotation.Bean;

public class Mobileconfig {
//	@Bean
	public Oneplus getOneplus() {
		return new Oneplus();
	}
//	@Bean
	public Iphone getIphone() {
		return new Iphone();
	}
}
