package com.niit.collabbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collabbackend.DAO.UserDAO;
import com.niit.collabbackend.model.Users;

public class UserTestCase {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		context.getBean("user");
		
		UserDAO userDAO= (UserDAO)context.getBean("userDAO");
		Users user=(Users)context.getBean("user");
		user.setName("Payal");
		user.setIsOnline("true");
		user.setPassword("1234");
		user.setRole("user");
		user.setStatus("approved");
		user.setEmail("pay@gmail.com");
		userDAO.saveOrUpdate(user);
		System.out.println("user created");
	
	}

}
