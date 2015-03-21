package edu.sjsu.cmpe275.lab1.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.sjsu.cmpe275.lab1.exception.UnAuthorisedException;
import edu.sjsu.cmpe275.lab1.service.FileService;
import edu.sjsu.cmpe275.lab1.service.IFileService;


public class SpringMain {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		IFileService fileService = (IFileService) ctx.getBean("fileService");
		try{
		
		
			fileService.readFile("Surabhi", "home/Surabhi/shared/SurabhiText.txt");
		
		}
		catch(UnAuthorisedException un) {
			System.out.println(un.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		//fileService.getFile().throwException();
		
		((AbstractApplicationContext) ctx).close();
	}

}
