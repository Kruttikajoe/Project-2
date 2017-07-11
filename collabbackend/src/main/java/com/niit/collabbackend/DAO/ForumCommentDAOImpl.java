package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public boolean addOrUpdateForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in addOrUpdateForumComment");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteForumComment(ForumComment forumComment) {
		try {
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in deleteForumComment");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ForumComment getParticularForumComment(int fComment_id) {
		try {
			return (ForumComment) sessionFactory.getCurrentSession().get(ForumComment.class, fComment_id);
		} catch (Exception e) {
			System.out.println("Exception in getParticularForumComment");
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	@Transactional
	public List<ForumComment> getParticularForumCommentsList(int forum_id) {
		try {
			return sessionFactory.getCurrentSession().createCriteria(ForumComment.class)
					.add(Restrictions.eq("forum_id", forum_id)).list();
		} catch (Exception e) {
			System.out.println("Exception in getParticularForumCommentsList");
			e.printStackTrace();
			return null;
		}
	}

}
