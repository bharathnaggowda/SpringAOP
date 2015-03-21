package edu.sjsu.cmpe275.lab1.test;

import org.junit.Before;
import org.junit.Test;

import edu.sjsu.cmpe275.lab1.service.IFileService;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring.xml" })
public class FileServiceTest {
	
	ApplicationContext ac;

	/**
	 * @throws Exception
	 */
	
	@Before
	public void setUp() throws Exception
	{
	ac = new FileSystemXmlApplicationContext("src/main/resources/spring.xml");
	}

	@Autowired
	IFileService fileService;

	/**
	 * testA:It checks without Surabhi sharing her file with Bharath,
	 *  whether Bharath can read the Surabhi's file /home/Surabhi/shared/SurabhiText.txt 
	 *  Bharath cannot read Surabhi’s file /home/Surabhi/shared/SurabhiText.txt.
	 */
	@Test
	public void testA() {
	        	System.out.println("Executing testA");
	        	try{
	        		fileService.readFile("Bharath", "home/Surabhi/shared/SurabhiText.txt");
	        		assert true;
	        	}catch(Exception e){
	        		
	        		//e.printStackTrace();
	        		assert false;
	        		System.out.println("Failed to read file");
	        	}
	}
  
	/**
	 * TestB : Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with bharath
	 * It checks Bharath can read the Surabhi's file /home/Surabhi/shared/SurabhiText.txt 
	 * Bharath can read the file home/Surabhi/shared/SurabhiText.txt and its contents
	 */
	@Test
	public void testB(){
	        	System.out.println("Executing testB");
	        	try{
	        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
	        	fileService.readFile("Bharath", "home/Surabhi/shared/SurabhiText.txt");
	        	assert true;
	        	}catch(Exception e){
	        		assert false;
	        	}
	}
	
	/**
	 * TestC : Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with bharath
	 * It checks Bharath can read the Surabhi's file /home/Surabhi/shared/SurabhiText.txt 
	 * Bharath can read the file home/Surabhi/shared/SurabhiText.txt and its contents
	 * Bharath shares the file home/Surabhi/shared/SurabhiText.txt with Carl
	 * It checks Carl can read the Surabhi's file /home/Surabhi/shared/SurabhiText.txt 
	 * Carl can read the file home/Surabhi/shared/SurabhiText.txt and its contents
	 */
	@Test
	public void testC(){
	        	System.out.println("Executing testC");
	        	try{
		        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.readFile("Bharath", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.shareFile("Bharath", "Carl", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.readFile("Carl", "home/Surabhi/shared/SurabhiText.txt");
		        	assert true;
		        	}catch(Exception e){
		        		assert false;
		        	}
	}
	
	/**
	 * TestC : Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Bharath shares the file home/carl/shared/SurabhiText.txt with Surabhi
	 * Get an exception
	 */
	@Test
	public void testD() {
	        	System.out.println("Executing testD");
	        	try{
		        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
		        	//fileService.readFile("Bharath", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.shareFile("Bharath", "Surabhi", "home/Carl/shared/CarlText.txt");
		        	//fileService.readFile("Carl", "home/Surabhi/shared/SurabhiText.txt");
		        	assert false;
		        	}catch(Exception e){
		        		assert true;
		        		System.out.println("Failed to share file");
		        	}
	}
	
	/**
	 * TestE : Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Bharath shares the file home/Surabhi/shared/SurabhiText.txt with Carl
	 * Surabhi unshares the file home/Surabhi/shared/SurabhiText.txt with Carl
	 * Carl tries to read the file
	 * Get an exception : Carl cannot read the File
	 */
	@Test
	public void testE(){
	        	System.out.println("Executing testE");
	        	try{
		        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.shareFile("Bharath", "Carl", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.unshareFile("Surabhi", "Carl", "home/Surabhi/shared/SurabhiText.txt");
		        	fileService.readFile("Carl", "home/Surabhi/shared/SurabhiText.txt");
		        	assert false;
		        	}catch(Exception e){
		        		assert true;
		        		System.out.println("Failed to read file");
		        	}
	}
	/**
	 * Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with Carl
	 * Carl shares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Surabhi unshares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Bharath reads the file but gets Exception : Bharath cannot read the file home/Surabhi/shared/SurabhiText.txt
	 */
	@Test
	public void testF(){
    	System.out.println("Executing testF");
    	try{
        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.shareFile("Surabhi", "Carl", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.shareFile("Carl", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.unshareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.readFile("Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	assert false;
        	}catch(Exception e){
        		assert true;
        		System.out.println("Failed to read file");
        	}
	}
	/**
	 * Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Bharath shares the file home/Surabhi/shared/SurabhiText.txt with Carl
	 * Surabhi unshares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Bharath shares the file home/Surabhi/shared/SurabhiText.txt with Carl
	 * Gets an exception.
	 * Carl reads the file 
	 */
	@Test
	public void testG(){
    	System.out.println("Executing testG");
    	try{
        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.shareFile("Bharath", "Carl", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.unshareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.shareFile("Bharath", "Carl", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.readFile("Carl", "home/Surabhi/shared/SurabhiText.txt");
        	assert false;
        	}catch(Exception e){
        		assert true;
        		System.out.println("Failed to Share the file");
        	}
    	}
	/**
	 * Surabhi shares the file home/Surabhi/shared/SurabhiText.txt with Bharath
	 * Bharath tries to read file home/Surabhi/shared/SurabhiText2.txt
	 * Gets an exception: Bharath cannot read file home/Surabhi/shared/SurabhiText2.txt
	 */
	@Test
	public void testH(){
    	System.out.println("Executing testH");
    	try{
        	fileService.shareFile("Surabhi", "Bharath", "home/Surabhi/shared/SurabhiText.txt");
        	fileService.readFile("Bharath", "home/Surabhi/shared/SurabhiText2.txt");
        	assert false;
        	}catch(Exception e){
        		assert true;
        		System.out.println("Failed to read file");
        	}
	}
	
}
