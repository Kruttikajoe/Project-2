package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.BlogComment;

public class BlogCommentDAOImpl implements BlogCommentDAO {

	public BlogCommentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean saveOrUpdateBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in saveOrUpdateBlogComment of BlogCommentDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	

	@Override
	@Transactional
	public List<BlogComment> getListOfBlogComments() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("From BlogComment").getResultList();
			}
		catch(Exception e)
		{
			System.out.println("Exception in getListOfBlogComments of BlogCommentDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public BlogComment getParticularBlogComment(int blog_comment_id) {
		try
		{
			return (BlogComment)sessionFactory.getCurrentSession().get(BlogComment.class, blog_comment_id);	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getParticularBlogComment of BlogCommentDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in deleteBlogComment of BlogCommentDAOImpl");
			e.printStackTrace();
			return false;
		}
	}
}
