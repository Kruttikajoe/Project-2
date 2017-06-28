package com.niit.collabbackend;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collabbackend.DAO.BlogDAO;
import com.niit.collabbackend.model.Blog;

public class BlogTestCase {

	public BlogTestCase() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com");
		context.refresh();
		context.getBean("blog");
		
		BlogDAO blogDAO= (BlogDAO)context.getBean("blogDAO");
		Blog blog=(Blog)context.getBean("blog");
		blog.setBlog_name("Angular js1");
		blog.setBlog_content("");
		blog.setCreate_date(new Date());
		blog.setLikes(10);
		blog.setStatus("Approved");
		blog.setUserid(1);
		blogDAO.addOrUpdateBlog(blog);
		System.out.println("blog created");
		
	}

}
