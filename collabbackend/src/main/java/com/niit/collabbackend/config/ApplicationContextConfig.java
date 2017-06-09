package com.niit.collabbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.collabbackend.DAO.BlogCommentDAO;
import com.niit.collabbackend.DAO.BlogCommentDAOImpl;
import com.niit.collabbackend.DAO.BlogDAO;
import com.niit.collabbackend.DAO.BlogDAOImpl;
import com.niit.collabbackend.DAO.ForumCommentDAO;
import com.niit.collabbackend.DAO.ForumCommentDAOImpl;
import com.niit.collabbackend.DAO.ForumDAO;
import com.niit.collabbackend.DAO.ForumDAOImpl;
import com.niit.collabbackend.DAO.JobDAO;
import com.niit.collabbackend.DAO.JobDAOImpl;
import com.niit.collabbackend.DAO.UserDAO;
import com.niit.collabbackend.DAO.UserDAOImpl;
import com.niit.collabbackend.model.Blog;
import com.niit.collabbackend.model.BlogComment;
import com.niit.collabbackend.model.Forum;
import com.niit.collabbackend.model.ForumComment;
import com.niit.collabbackend.model.Job;
import com.niit.collabbackend.model.Users;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement

public class ApplicationContextConfig {
	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource= new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("CollaborationDB");
		datasource.setPassword("CollaborationDB");
		System.out.println("Datasource");
		return datasource;
	}

private Properties getHibernateProperties()
{
	Properties prop=new Properties();
	prop.put("hibernate.show_sql","true");
	prop.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	prop.put("hibernate.hbm2ddl.auto", "update");
	prop.put("hibernate.current_session_context_class","thread");
	System.out.println("Hibernate Properties");
	return prop;
}

@Autowired
@Bean (name="sessionFactory")
public SessionFactory getSessionFactory(DataSource datasource)
{
	LocalSessionFactoryBuilder sessionBuilder= new LocalSessionFactoryBuilder(datasource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(Users.class);
	sessionBuilder.addAnnotatedClass(Blog.class);
	sessionBuilder.addAnnotatedClass(Forum.class);
	sessionBuilder.addAnnotatedClass(Job.class);
	sessionBuilder.addAnnotatedClass(BlogComment.class);
	sessionBuilder.addAnnotatedClass(ForumComment.class);
    System.out.println("Session Factory");
	return sessionBuilder.buildSessionFactory();
	
}

@Autowired 
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
	System.out.println("Transaction Manager");
	return transactionManager;
}

@Autowired
@Bean(name="userDAO")
public UserDAO getUserDAO(SessionFactory sessionFactory)
{
	System.out.println("user DAO");
	return new UserDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="user")

public Users getUser()
{
	System.out.println("user");
	return new Users();
}

@Autowired
@Bean(name="blogDAO")
public BlogDAO getBlogDAO(SessionFactory sessionFactory)
{
	System.out.println("blog DAO");
	return new BlogDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="blog")

public Blog getBlog()
{
	System.out.println("Blog");
	return new Blog();
}

@Autowired
@Bean(name="forumDAO")
public ForumDAO getForumDAO(SessionFactory sessionFactory)
{
	System.out.println("Forum DAO");
	return new ForumDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="forum")

public Forum getForum()
{
	System.out.println("Forum");
	return new Forum();
}

@Autowired
@Bean(name="jobDAO")
public JobDAO getJobDAO(SessionFactory sessionFactory)
{
	System.out.println("Job DAO");
	return new JobDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="job")

public Job getJob()
{
	System.out.println("Job");
	return new Job();
}

@Autowired
@Bean(name="blogCommentDAO")
public BlogCommentDAO getBlogCommentDAO(SessionFactory sessionFactory)
{
	System.out.println("BlogComment DAO");
	return new BlogCommentDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="blogComment")

public BlogComment getBlogComment()
{
	System.out.println("BlogComment");
	return new BlogComment();
}

@Autowired
@Bean(name="forumCommentDAO")
public ForumCommentDAO getForumCommentDAO(SessionFactory sessionFactory)
{
	System.out.println("ForumComment DAO");
	return new ForumCommentDAOImpl(sessionFactory);
	
}

@Autowired
@Bean(name="forumComment")

public ForumComment getForumComment()
{
	System.out.println("ForumComment");
	return new ForumComment();
}

}
