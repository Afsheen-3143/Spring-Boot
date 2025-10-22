package DI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  context=new ClassPathXmlApplicationContext("Emp.xml");
		Employee employe=(Employee) context.getBean("emp");
		System.out.println(employe.getDepartment().getDeptname());
		System.out.println(employe.getEmpid());
		System.out.println(employe.getEmpname());

	}

}
