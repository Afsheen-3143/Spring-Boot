package Ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Ioc.Mobileconfig;
import Ioc.Mobiles;

public class Mobilemain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Mobileconfig.class);
		Mobiles obj=context.getBean("getIphone",Mobiles.class);
		obj.getcolourandmodel();

	}

}
