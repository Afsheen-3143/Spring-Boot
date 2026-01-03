package com.example.aop.aspectservice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {

    @Before(
        value = "execution(* com.example.aop.service.EmployeeService.createEmp(..)) && args(empId, firstName, secondName)"
    )
    public void beforeCreateEmployee(
            JoinPoint joinPoint,
            String empId,
            String firstName,
            String secondName) {

        System.out.println("Before Method: " + joinPoint.getSignature());
        System.out.println("Creating employee -> ID: " + empId
                + ", FirstName: " + firstName
                + ", LastName: " + secondName);
    }

    @After(
        value = "execution(* com.example.aop.service.EmployeeService.createEmp(..))"
    )
    public void afterCreateEmployee(JoinPoint joinPoint) {
        System.out.println("After Method (finally): " + joinPoint.getSignature());
    }

    @AfterReturning(
        value = "execution(* com.example.aop.service.EmployeeService.createEmp(..))",
        returning = "employee"
    )
    public void afterReturningCreateEmployee(
            JoinPoint joinPoint,
            Object employee) {

        System.out.println("AfterReturning Method: " + joinPoint.getSignature());
        System.out.println("Employee created successfully -> " + employee);
    }

    @AfterThrowing(
        value = "execution(* com.example.aop.service.EmployeeService.createEmp(..))",
        throwing = "ex"
    )
    public void afterThrowingCreateEmployee(
            JoinPoint joinPoint,
            Exception ex) {

        System.out.println("AfterThrowing Method: " + joinPoint.getSignature());
        System.out.println("Exception occurred: " + ex.getMessage());
    }

    @After(
        value = "execution(* com.example.aop.service.EmployeeService.deleteEmployee(..)) && args(empId)"
    )
    public void afterDeleteEmployee(
            JoinPoint joinPoint,
            String empId) {

        System.out.println("After Delete Method: " + joinPoint.getSignature());
        System.out.println("Employee with ID " + empId + " deleted");
    }
    
    @Around(value="execution(*com.example.aop.service.Employeeservice.createEmp(..))")
    public Object createEmp(ProceedingJoinPoint joinpoint)throws Throwable{
    	System.out.println("Around before method"+joinpoint.getSignature());
    	Object result;
    	try {
    		result=joinpoint.proceed();
    		System.out.println("Around after method"+joinpoint.getSignature());
    		
    	}catch(Exception ex) {
    		System.out.println("Around after Exception"+ex.getMessage());
    		throw ex;
    	}
    	 System.out.println("Around FINALLY block");
    	return result;
    }
}
