package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.Blog;

@EnableTransactionManagement

public class BlogDAOImpl implements BlogDAO {

	private SessionFactory sessionFactory;

	public BlogDAOImpl() {
		super();
	}

	public BlogDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addOrUpdateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in addOrUpdateBlog of BlogDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in deleteBlog of BlogDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Blog> getListOfBlog() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog", Blog.class).getResultList();
		} catch (Exception e) {
			System.out.println("Exception in getListOfBlog of BlogDAOImpl");
			return null;
		}
	}

	@Transactional
	public Blog getParticularBlog(int blogid) {
		try {
			return (Blog) sessionFactory.getCurrentSession().get(Blog.class, blogid);
		} catch (Exception e) {
			System.out.println("Exception in getParticularBlog of BlogDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}
