package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.ForumComment;

public class ForumCommentDAOImpl implements ForumCommentDAO {
	
	private SessionFactory sessionFactory;

	public ForumCommentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ForumCommentDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean saveOrUpdateForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in saveOrUpdateForumComment of ForumCommentDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in deleteForumComment of deleteForumComment");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<ForumComment> getListOfForumComments() {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("From ForumComment").getResultList();
			}
		catch(Exception e)
		{
			System.out.println("Exception in getListOfForumComments of ForumCommentDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public ForumComment getParticularForumComment(int forum_comment_id) {
		try
		{
			return sessionFactory.getCurrentSession().get(ForumComment.class, forum_comment_id);	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getParticularForumComment of ForumCommentDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}
