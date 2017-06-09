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

	@Override
	@Transactional
	public boolean saveOrUpdate(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occured");
			return false;
		}
	}

	@Override
	@Transactional
	public Forum getForum(String id) {
		try {

			return sessionFactory.getCurrentSession().createQuery("from Forum where forum_id=:id", Forum.class)
					.setParameter("id", id).getSingleResult();

		} catch (Exception e) {
			System.out.println("Exception in get method of forumDAO");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public List<Forum> getAllForums() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Forum", Forum.class).getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
