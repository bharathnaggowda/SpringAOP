package edu.sjsu.cmpe275.lab1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FileAspectPointcut {

	@Before("getNamePointcut()")
	public void loggingAdvice(){
		System.out.println("Executing loggingAdvice on getUserId()");
	}
	
	@Before("getNamePointcut()")
	public void secondAdvice(){
		System.out.println("Executing secondAdvice on getUserId()");
	}
	
	@Pointcut("execution(public String getUserId())")
	public void getNamePointcut(){}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice(){
		System.out.println("Before executing service method");
	}
	
	//Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(edu.sjsu.cmpe275.lab1.service.*)")
	public void allMethodsPointcut(){}
	
}
