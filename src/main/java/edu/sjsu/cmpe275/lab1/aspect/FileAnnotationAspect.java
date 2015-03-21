package edu.sjsu.cmpe275.lab1.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FileAnnotationAspect {

	
	@Before("@annotation(edu.sjsu.cmpe275.lab1.aspect.Loggable)")
	public void myAdvice(){
		System.out.println("Executing myAdvice!!");
	}
}
