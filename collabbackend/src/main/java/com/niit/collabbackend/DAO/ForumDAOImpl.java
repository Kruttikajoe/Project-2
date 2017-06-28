package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.Forum;

public class ForumDAOImpl implements ForumDAO {

	private SessionFactory sessionFactory;

	public ForumDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public ForumDAOImpl() {
		super();
	}

	@Transactional
	public boolean addOrUpdateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in addOrUpdateForum of ForumDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in deleteForum of ForumDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Forum> getListOfForum() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Forum", Forum.class).getResultList();
		} catch (Exception e) {
			System.out.println("Exception in getListOfForum of ForumDAOImpl");
			return null;
		}
	}

	@Transactional
	public Forum getParticularForum(int forumid) {
		try {
			return (Forum) sessionFactory.getCurrentSession().get(Forum.class, forumid);
		} catch (Exception e) {
			System.out.println("Exception in getParticularForum of ForumDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}
