package edu.sjsu.cmpe275.lab1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class FileXMLConfigAspect {

	/**
	 * @param proceedingJoinPoint
	 * @return returns value that is userId
	 */
	public Object fileAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("FileXMLConfigAspect:: Before invoking getUserId() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("FileXMLConfigAspect:: After invoking getUserId() method. Return value="+value);
		return value;
	}
}
