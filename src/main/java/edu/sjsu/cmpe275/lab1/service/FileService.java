package edu.sjsu.cmpe275.lab1.service;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class FileService implements IFileService{

	public static HashMap<String, HashSet<String>> userData;
	
	public FileService(){
		userData = new HashMap<String, HashSet<String>>();
		userData.put("Bharath", new HashSet<String>());
		userData.put("Surabhi", new HashSet<String>());
		userData.put("Carl", new HashSet<String>());
		
	}
	
	/**
     * Share a file with another user. The file may or may not be present in the current user's path.
     * @param userId the ID of the current user
     * @param targetUserID the ID of the user, to whom the file needs to be shared.
     * @param filePath location of the file to be shared.
     */
	/* (non-Javadoc)
	 
	 * @see edu.sjsu.cmpe275.lab1.service.IFileService#shareFile(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void shareFile(String userId, String targetUserID, String filePath) {
		userData.get(targetUserID).add(filePath);
	}

	/* (non-Javadoc)
	 * Stop sharng a file with another user. The file may or may not be present in the current user's path.
	 * @param userId the ID of the current user
     * @param targetUserID the ID of the user, to whom the sharing needs to be stopped.
     * @param filePath location of the file to be shared.
	 * @see edu.sjsu.cmpe275.lab1.service.IFileService#unshareFile(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void unshareFile(String userId, String targetUserID, String filePath) {
		userData.get(targetUserID).remove(filePath);
	}
	
	/**
     * Read the shared file or owned file and return the contents.
     * @param userId the ID of the current user
     * @param filePath the path of the file for which the user is requesting access.
     * @return Returns the contents of the file, or null if the file does not exist.
     */
	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.lab1.service.IFileService#readFile(java.lang.String, java.lang.String)
	 */
	public byte[] readFile(String userId, String filePath) {
		//ByteBuilder builder = new ByteBuilder();
		
		StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        try {
        	int i = 1;
            reader = new BufferedReader(new FileReader(filePath));
            String line = null;
            System.out.println("reading file "+ filePath);
            while ((line = reader.readLine()) != null){
            	builder.append(line);
            	System.out.println("Contents of the file-------->"+line);
            	i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(reader);
        }
        String data = builder.toString();
        //System.out.println(data);
        return data.getBytes();
    }
	
	/**
	 * @param c
	 */
	private void closeQuietly(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ignored) {}
        }
    }
}
