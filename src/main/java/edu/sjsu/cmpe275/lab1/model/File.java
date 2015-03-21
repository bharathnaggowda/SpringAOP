package edu.sjsu.cmpe275.lab1.model;

import edu.sjsu.cmpe275.lab1.aspect.Loggable;

public class File {

	private String userId;
	private String targetUserId;
	private String filePath;	
	
	/**
	 * @return returns the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the ID of the current user
	 */
	@Loggable
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return return targetUserId the ID of the user, to whom file need to be shared or unshared
	 */
	public String getTargetUserId() {
		return targetUserId;
	}

	/**
	 * @param targetUserId the ID of the user, to whom file need to be shared or unshared
	 */
	@Loggable
	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}

	/**
	 * @return returns filePath location of the file to be shared.
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath location of the file to be shared.
	 */
	@Loggable
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}
}
