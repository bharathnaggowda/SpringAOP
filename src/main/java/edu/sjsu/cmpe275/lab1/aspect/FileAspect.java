package edu.sjsu.cmpe275.lab1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FileAspect {

	@Before("execution(public String getUserId())")
	public void getNameAdvice(){
		System.out.println("Executing Advice on getUserId()");
	}
	
	@Before("execution(* edu.sjsu.cmpe275.lab1.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");
	}
}
