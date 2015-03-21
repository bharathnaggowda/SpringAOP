package edu.sjsu.cmpe275.lab1.exception;

public class UnAuthorisedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UnAuthorisedException(){
		
	}

	/**
	 * @param s 
	 */
	public UnAuthorisedException(String s) {
		super(s);
	}

}
