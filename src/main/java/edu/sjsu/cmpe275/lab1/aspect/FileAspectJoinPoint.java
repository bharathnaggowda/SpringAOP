package edu.sjsu.cmpe275.lab1.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class FileAspectJoinPoint {

	
	/**
	 * @param joinPoint where the aspect code will be executed
	 */
	@Before("execution(public void edu.sjsu.cmpe275.lab1.model..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
		
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}
	
	//Advice arguments, will be applied to bean methods with single String argument
	/**
	 * @param userId
	 */
	@Before("args(userId)")
	public void logStringArguments(String userId){
		System.out.println("String argument passed="+userId);
	}
}
