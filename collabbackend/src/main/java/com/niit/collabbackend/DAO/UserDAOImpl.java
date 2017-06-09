package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.Users;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public UserDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean saveOrUpdate(Users user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occured");
			return false;
		}
	}

	@Transactional
	public List<Users> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Users", Users.class).getResultList();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	@Transactional
	public boolean delete(Users user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public Users get(String email) {
		try {

			return sessionFactory.getCurrentSession().createQuery("from Users where emailid=:email", Users.class)
					.setParameter("email", email).getSingleResult();

		} catch (Exception e) {
			System.out.println("Exception in get method of userDAO");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Users> getListOFUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getParticularUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Object particularUser) {
		// TODO Auto-generated method stub
		
	}

}
