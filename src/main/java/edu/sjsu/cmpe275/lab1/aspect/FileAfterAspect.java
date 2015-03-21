package edu.sjsu.cmpe275.lab1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FileAfterAspect {

	/**
	 * @param userId
	 */
	@After("args(userId)")
	public void logStringArguments(String userId){
		System.out.println("Running After Advice. String argument passed="+userId);
	}
	
	/**
	 * @param joinPoint where the aspect code will be executed
	 */
	@AfterThrowing("within(edu.sjsu.cmpe275.lab1.model.File)")
	public void logExceptions(JoinPoint joinPoint){
		System.out.println("Exception thrown in File Method="+joinPoint.toString());
	}
	
	/**
	 * @param returnString
	 */
	@AfterReturning(pointcut="execution(* getUserId())", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("getNameReturningAdvice executed. Returned String="+returnString);
	}
	
}
