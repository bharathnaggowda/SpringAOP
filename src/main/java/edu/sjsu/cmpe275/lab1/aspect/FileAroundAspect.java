package edu.sjsu.cmpe275.lab1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class FileAroundAspect {

	/**
	 * @param proceedingJoinPoint 
	 * @return value : reads the content of the file read
	 */
	@Around("execution(* edu.sjsu.cmpe275.lab1.service.FileService.readFile())")
	public Object fileAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Before invoking readFile() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking readFile() method");
		return value;
	}
}
