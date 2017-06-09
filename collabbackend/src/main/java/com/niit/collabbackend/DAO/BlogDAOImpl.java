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

	@Override
	@Transactional
	public Blog getBlog(String id) {
		try {

			return sessionFactory.getCurrentSession().createQuery("from Blog where blog_id=:id", Blog.class)
					.setParameter("id", id).getSingleResult();

		} catch (Exception e) {
			System.out.println("Exception in get method of blogDAO");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public List<Blog> getAllBlogs() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog", Blog.class).getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occured");
			return false;
		}
	}

}
