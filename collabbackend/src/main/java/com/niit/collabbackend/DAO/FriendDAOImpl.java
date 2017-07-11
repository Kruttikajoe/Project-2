package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.Friend;

public class FriendDAOImpl implements FriendDAO {

	private SessionFactory sessionFactory;

	public FriendDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FriendDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean addOrUpdateFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in addOrUpdateFriend of FriendDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteFriend(Friend friend) {
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in deleteFriend of FriendDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Friend> getListOfFriend() {
		try {
			return sessionFactory.openSession().createQuery("from Friend").getResultList();
		} catch (Exception e) {
			System.out.println("Exception in getListOfFriend of FriendDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	public Friend getParticularFriend(int friend_id) {
		try {
			return (Friend) sessionFactory.getCurrentSession().get(Friend.class, friend_id);
		} catch (Exception e) {
			System.out.println("Exception in getParticularFriend of FriendDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}
