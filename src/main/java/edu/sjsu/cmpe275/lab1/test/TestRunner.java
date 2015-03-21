package edu.sjsu.cmpe275.lab1.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	      Result result = JUnitCore.runClasses(JunitTestSuite.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	   }
}
