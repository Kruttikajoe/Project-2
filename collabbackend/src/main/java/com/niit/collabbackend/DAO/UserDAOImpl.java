package com.niit.collabbackend.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

	@Transactional
	public boolean addOrUpdateUser(Users user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in addOrUpdateUser of UserDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public boolean deleteUser(Users user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (Exception e) {
			System.out.println("Exception in deleteUser of UserDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	public List<Users> getListOFUsers() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Users", Users.class).getResultList();
		} catch (Exception e) {
			System.out.println("Exception in getListOFUsers of UserDAOImpl");
			return null;
		}
	}

	@Transactional
	public Users getParticularUser(int user_id) {
		try {
			return (Users) sessionFactory.getCurrentSession().get(Users.class, user_id);
		} catch (Exception e) {
			System.out.println("Exception in getParticularUser of UserDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Transactional
	public Users validateUser(String email, String password) {
		try {
			Session session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(Users.class).add(Restrictions.eq("email", email))
					.add(Restrictions.eq("password", password));
			Users user = (Users) cr.uniqueResult();
			session.close();
			return user;
		} catch (Exception e) {
			System.out.println("Exception in validateUser of UserDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}
