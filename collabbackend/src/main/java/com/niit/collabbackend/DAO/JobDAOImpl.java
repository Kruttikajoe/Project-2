package com.niit.collabbackend.DAO;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collabbackend.model.Job;

@EnableTransactionManagement

public class JobDAOImpl implements JobDAO {
	
	private SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public JobDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public boolean addOrUpdateJob(Job job) {
		try
		{
			sessionFactory.openSession().saveOrUpdate(job);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in addOrUpdateJob of JobDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception in deleteJob of JobDAOImpl");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional
	public List<Job> getListOfJob() {
		try
		{
			return sessionFactory.openSession().createQuery("from Job").getResultList();
			}
		catch(Exception e)
		{
			System.out.println("Exception in getListOfJob of JobDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public Job getParticularJob(int job_id) {
		try
		{
			return (Job)sessionFactory.getCurrentSession().get(Job.class, job_id);	
		}
		catch(Exception e)
		{
			System.out.println("Exception in getParticularJob of JobDAOImpl");
			e.printStackTrace();
			return null;
		}
	}

}
